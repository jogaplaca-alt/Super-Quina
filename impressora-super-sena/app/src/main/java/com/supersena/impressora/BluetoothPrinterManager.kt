package com.supersena.impressora
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.OutputStream
import java.util.UUID
class BluetoothPrinterManager private constructor(context:Context) {
 private val prefs=context.applicationContext.getSharedPreferences("thermal_printer_preferences",Context.MODE_PRIVATE)
 private val adapter=BluetoothAdapter.getDefaultAdapter()
 @Volatile private var socket:BluetoothSocket?=null
 @Volatile private var output:OutputStream?=null
 @Volatile var printerName:String?=null; private set
 val savedMacAddress get()=prefs.getString("last_printer_mac",null)
 suspend fun rememberPrinter(d:BluetoothDevice)=withContext(Dispatchers.IO){prefs.edit().putString("last_printer_mac",d.address).apply()}
 suspend fun connect(d:BluetoothDevice):Result<String> = withContext(Dispatchers.IO){runCatching{connectInternal(d);d.name?:d.address}}
 suspend fun reconnectSaved():Result<String> = withContext(Dispatchers.IO){runCatching{
  val mac=prefs.getString("last_printer_mac",null)?:throw IOException("Nenhuma impressora salva.")
  val bt=adapter?:throw IOException("Bluetooth indisponivel."); val d=bt.getRemoteDevice(mac); connectInternal(d); d.name?:mac
 }}
 private fun connectInternal(d:BluetoothDevice) {
  closeSocket(); val bt=adapter?:throw IOException("Bluetooth indisponivel.")
  if(!bt.isEnabled) throw IOException("Ative o Bluetooth do celular.")
  bt.cancelDiscovery()
  var first:Exception?=null
  val primary=try{d.createRfcommSocketToServiceRecord(SPP).also{it.connect()}}catch(e:Exception){first=e;null}
  val connected=primary?:try{
   val fallback=d.javaClass.getMethod("createRfcommSocket",Int::class.javaPrimitiveType).invoke(d,1) as BluetoothSocket
   fallback.connect();fallback
  }catch(e:Exception){closeSocket();throw IOException("Falha SPP UUID/canal 1: ${e.message?:first?.message}",e)}
  socket=connected;output=connected.outputStream;printerName=d.name?:d.address
 }
 suspend fun print(bytes:ByteArray):Result<Unit> = withContext(Dispatchers.IO){runCatching{
  try{ensureConnected();writeAll(bytes)}catch(first:IOException){
   closeSocket();delay(800)
   try{reconnectSaved().getOrThrow();ensureConnected();writeAll(bytes)}
   catch(second:Exception){closeSocket();throw IOException("Falha apos reconexao: ${second.message?:first.message}",second)}
  }
 }}
 private fun ensureConnected(){
  if(socket?.isConnected==true&&output!=null)return
  val mac=prefs.getString("last_printer_mac",null)?:throw IOException("Selecione uma impressora.")
  val bt=adapter?:throw IOException("Bluetooth indisponivel.");connectInternal(bt.getRemoteDevice(mac))
 }
 private fun writeAll(b:ByteArray){val s=output?:throw IOException("Fluxo indisponivel.");s.write(b);s.flush()}
 suspend fun disconnect()=withContext(Dispatchers.IO){closeSocket()}
 private fun closeSocket(){try{output?.close()}catch(_:Exception){};try{socket?.close()}catch(_:Exception){};output=null;socket=null;printerName=null}
 companion object {
  private val SPP=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
  @Volatile private var instance:BluetoothPrinterManager?=null
  fun getInstance(c:Context)=instance?:synchronized(this){instance?:BluetoothPrinterManager(c).also{instance=it}}
 }
}