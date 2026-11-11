package com.supersena.impressora
import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
class MainActivity:AppCompatActivity(){
 private lateinit var manager:BluetoothPrinterManager
 private lateinit var status:TextView
 private lateinit var input:EditText
 private var pending:(()->Unit)?=null
 private val permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){r->
  val ok=permissions().all{r[it]==true||ContextCompat.checkSelfPermission(this,it)==PackageManager.PERMISSION_GRANTED}
  if(ok)pending?.invoke() else showStatus("Permissoes Bluetooth nao concedidas.");pending=null
 }
 override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContentView(R.layout.activity_main)
  manager=BluetoothPrinterManager.getInstance(applicationContext);status=findViewById(R.id.connectionStatus);input=findViewById(R.id.testText)
  findViewById<Button>(R.id.listPrintersButton).setOnClickListener{withPermissions{showPaired()}}
  findViewById<Button>(R.id.printTestButton).setOnClickListener{withPermissions{printTest()}}
  if(manager.savedMacAddress!=null)withPermissions{showStatus("Conectando...");lifecycleScope.launch{
   manager.reconnectSaved().onSuccess{showStatus("Conectado em $it")}.onFailure{showStatus("Desconectado: ${it.message}")}
  }}else showStatus("Desconectado")
 }
 private fun permissions()=if(Build.VERSION.SDK_INT>=31)arrayOf(Manifest.permission.BLUETOOTH_CONNECT,Manifest.permission.BLUETOOTH_SCAN) else arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
 private fun withPermissions(a:()->Unit){val missing=permissions().filter{ContextCompat.checkSelfPermission(this,it)!=PackageManager.PERMISSION_GRANTED}
  if(missing.isEmpty())a() else{pending=a;permissionLauncher.launch(missing.toTypedArray())}}
 @Suppress("MissingPermission") private fun showPaired(){
  val bt=BluetoothAdapter.getDefaultAdapter();if(bt==null){showStatus("Bluetooth nao disponivel.");return}
  if(!bt.isEnabled){showStatus("Ative o Bluetooth.");return}
  val ds=try{bt.bondedDevices.orEmpty().toList()}catch(e:SecurityException){showStatus("Permissao Bluetooth negada.");return}
  if(ds.isEmpty()){AlertDialog.Builder(this).setTitle("Impressoras pareadas").setMessage("Pareie a impressora nas configuracoes Bluetooth do Android.").setPositiveButton("OK",null).show();return}
  val labels=ds.map{"${it.name?: "Dispositivo"}\n${it.address}"}.toTypedArray()
  AlertDialog.Builder(this).setTitle("Selecione a impressora").setAdapter(ArrayAdapter(this,android.R.layout.simple_list_item_1,labels)){_,i->select(ds[i])}.setNegativeButton("Cancelar",null).show()
 }
 @Suppress("MissingPermission") private fun select(d:BluetoothDevice){showStatus("Conectando...");lifecycleScope.launch{
  manager.rememberPrinter(d);manager.connect(d).onSuccess{showStatus("Conectado em $it")}.onFailure{showStatus("Desconectado: ${it.message}")}
 }}
 private fun printTest(){val t=SimpleDateFormat("dd/MM/yyyy HH:mm:ss",Locale("pt","BR")).format(Date());val b=EscPosHelper.buildTestPrint(input.text?.toString().orEmpty(),t)
  lifecycleScope.launch{manager.print(b).onSuccess{showStatus("Conectado em ${manager.printerName?:"impressora"}")}.onFailure{showStatus("Falha: ${it.message}")}}
 }
 private fun showStatus(s:String){if(::status.isInitialized)status.text=s}
}