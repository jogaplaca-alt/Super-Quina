package br.com.superquina.printbridge

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import java.io.IOException
import java.nio.charset.Charset
import java.util.UUID
import kotlin.concurrent.thread

class MainActivity : Activity() {
    private val sppUuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    private var selectedDevice: BluetoothDevice? = null
    private var pendingText: String? = null
    private var statusView: TextView? = null
    private var deviceContainer: LinearLayout? = null
    private var socket: BluetoothSocket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderScreen()
        handleIncomingIntent(intent)
        ensureBluetoothPermission()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIncomingIntent(intent)
    }

    private fun renderScreen() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 32, 28, 24)
        }
        root.addView(TextView(this).apply {
            text = "SUPERQUINA"
            textSize = 25f
            setTypeface(null, android.graphics.Typeface.BOLD)
        })
        root.addView(TextView(this).apply {
            text = "Ponte de impressão térmica"
            textSize = 16f
        })
        statusView = TextView(this).apply {
            text = "Selecione uma impressora Bluetooth pareada."
            textSize = 14f
            setPadding(0, 24, 0, 16)
        }
        root.addView(statusView)
        root.addView(Button(this).apply {
            text = "Atualizar impressoras pareadas"
            setOnClickListener { loadBondedDevices() }
        })
        val scroll = ScrollView(this)
        deviceContainer = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        scroll.addView(deviceContainer)
        root.addView(scroll, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
        ))
        root.addView(Button(this).apply {
            text = "Imprimir conteúdo recebido"
            setOnClickListener { pendingText?.let { printText(it) } ?: updateStatus("Nenhum texto recebido.") }
        })
        setContentView(root)
    }

    private fun handleIncomingIntent(intent: Intent?) {
        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            pendingText = intent.getStringExtra(Intent.EXTRA_TEXT)
            updateStatus(if (pendingText.isNullOrBlank()) "Compartilhamento sem texto." else "Conteúdo recebido. Escolha a impressora.")
            if (hasBluetoothPermission()) {
                loadBondedDevices()
                selectedDevice?.let { connectAndPrintIfReady(it) }
            }
        }
    }

    private fun ensureBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !hasBluetoothPermission()) {
            requestPermissions(arrayOf(Manifest.permission.BLUETOOTH_CONNECT), REQUEST_BT)
        } else {
            loadBondedDevices()
        }
    }

    private fun hasBluetoothPermission(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_BT && grantResults.firstOrNull() == PackageManager.PERMISSION_GRANTED) {
            loadBondedDevices()
        } else if (requestCode == REQUEST_BT) {
            updateStatus("Permissão Bluetooth necessária para acessar impressoras pareadas.")
        }
    }

    @Suppress("DEPRECATION")
    private fun loadBondedDevices() {
        if (!hasBluetoothPermission()) {
            ensureBluetoothPermission()
            return
        }
        val adapter = BluetoothAdapter.getDefaultAdapter()
        deviceContainer?.removeAllViews()
        if (adapter == null) {
            updateStatus("Este aparelho não possui Bluetooth.")
            return
        }
        if (!adapter.isEnabled) {
            updateStatus("Ative o Bluetooth do aparelho e atualize a lista.")
            return
        }
        val devices = try { adapter.bondedDevices.orEmpty().sortedBy { it.name ?: it.address } }
        catch (_: SecurityException) { emptyList() }
        if (devices.isEmpty()) updateStatus("Nenhuma impressora pareada. Pareie a impressora nas configurações do Android.")
        devices.forEach { device ->
            val label = (device.name ?: "Dispositivo Bluetooth") + "\n" + device.address
            deviceContainer?.addView(Button(this).apply {
                text = label
                isAllCaps = false
                setOnClickListener {
                    selectedDevice = device
                    updateStatus("Selecionada: ${device.name ?: device.address}. Conectando…")
                    connectAndPrintIfReady(device)
                }
            })
        }
    }

    private fun printText(text: String) {
        pendingText = text
        val device = selectedDevice
        if (device == null) {
            updateStatus("Selecione uma impressora Bluetooth antes de imprimir.")
            return
        }
        connectAndPrintIfReady(device)
    }

    private fun connectAndPrintIfReady(device: BluetoothDevice) {
        val text = pendingText
        if (text.isNullOrBlank()) {
            updateStatus("Impressora selecionada. Compartilhe um texto com Superquina Impressão para imprimir.")
            return
        }
        thread(name = "superquina-bt-connect") {
            try {
                closeSocket()
                val newSocket = device.createRfcommSocketToServiceRecord(sppUuid)
                socket = newSocket
                newSocket.connect()
                val payload = encodeEscPos(text)
                newSocket.outputStream.use { stream ->
                    stream.write(payload)
                    stream.flush()
                }
                runOnUiThread {
                    pendingText = null
                    updateStatus("Dados enviados à impressora. Confira a impressão.")
                }
                closeSocket()
            } catch (error: SecurityException) {
                runOnUiThread { updateStatus("Permissão Bluetooth negada: ${error.message ?: "sem detalhes"}") }
                closeSocket()
            } catch (error: IOException) {
                runOnUiThread { updateStatus("Falha na conexão/impressão: ${error.message ?: "verifique a impressora"}") }
                closeSocket()
            }
        }
    }

    private fun encodeEscPos(text: String): ByteArray {
        val cleanText = text.replace("\r\n", "\n").replace("\r", "\n")
        // Self-test da OY-5801P indica code page 3 = PC860 (português).
        // ESC t 3 seleciona a tabela de caracteres no firmware ESC/POS.
        val body = cleanText.toByteArray(Charset.forName("IBM860"))
        return byteArrayOf(
            0x1B, 0x40,       // ESC @: inicializar
            0x1B, 0x74, 0x03  // ESC t 3: selecionar PC860
        ) + body + byteArrayOf(0x0A, 0x0A, 0x0A)
    }

    private fun closeSocket() {
        try { socket?.close() } catch (_: IOException) { }
        socket = null
    }

    private fun updateStatus(message: String) {
        runOnUiThread { statusView?.text = message }
    }

    override fun onDestroy() {
        closeSocket()
        super.onDestroy()
    }

    companion object {
        private const val REQUEST_BT = 701
    }
}
