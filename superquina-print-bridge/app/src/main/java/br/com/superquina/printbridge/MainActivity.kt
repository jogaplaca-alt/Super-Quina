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
import org.json.JSONObject
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
            text = "SUPER QUINA"
            textSize = 25f
            setTypeface(null, android.graphics.Typeface.BOLD)
        })
        root.addView(TextView(this).apply {
            text = "Super Quina Impressão"
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
        root.addView(Button(this).apply {
            text = "Ativar serviço de impressão do Android"
            setOnClickListener {
                runCatching { startActivity(Intent(android.provider.Settings.ACTION_PRINT_SETTINGS)) }
                    .onFailure { updateStatus("Abra as configurações do Android e procure por Impressão.") }
            }
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
            // A share intent may have arrived before Android granted Bluetooth access.
            // Resume the pending receipt automatically once the permission is granted.
            selectedDevice?.let { device ->
                if (!pendingText.isNullOrBlank()) connectAndPrintIfReady(device)
            }
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
        val savedAddress = getSharedPreferences("superquina_print_bridge", MODE_PRIVATE)
            .getString("selected_printer_address", null)
        selectedDevice = devices.firstOrNull { it.address == savedAddress }
        if (devices.isEmpty()) updateStatus("Nenhuma impressora pareada. Pareie a impressora nas configurações do Android.")
        devices.forEach { device ->
            val label = (device.name ?: "Dispositivo Bluetooth") + "\n" + device.address
            deviceContainer?.addView(Button(this).apply {
                text = label
                isAllCaps = false
                setOnClickListener {
                    selectedDevice = device
                    getSharedPreferences("superquina_print_bridge", MODE_PRIVATE)
                        .edit().putString("selected_printer_address", device.address).apply()
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
            updateStatus("Impressora selecionada. Compartilhe um texto com Super Quina Impressão para imprimir.")
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
        val payload = runCatching { JSONObject(text) }.getOrNull()
        if (payload?.optString("type") == "superquina-receipt" && payload.optInt("version") == 1) {
            return encodeOfficialReceipt(payload)
        }
        val cleanText = text.replace("\\r\\n", "\\n").replace("\\r", "\\n")
        val body = cleanText.toByteArray(Charset.forName("IBM860"))
        return byteArrayOf(0x1B, 0x40, 0x1B, 0x74, 0x03) + body + byteArrayOf(0x0A, 0x0A, 0x0A)
    }

    private fun encodeOfficialReceipt(payload: JSONObject): ByteArray {
        val receipt = payload.optJSONObject("receipt") ?: throw IOException("Recibo inválido.")
        val code = receipt.optString("receiptCode")
        if (!code.matches(Regex("SQ-[A-Z0-9]{8,32}")) || receipt.optString("paymentStatus") != "CONFIRMED") {
            throw IOException("Somente recibos oficiais confirmados podem ser impressos.")
        }
        if (receipt.optString("currency") != "BRL") throw IOException("Moeda do recibo não suportada.")
        val entries = receipt.optJSONArray("entries") ?: throw IOException("Recibo sem apostas.")
        if (entries.length() !in 1..100) throw IOException("Quantidade de apostas inválida.")

        val lines = mutableListOf<String>()
        lines += "SUPER QUINA"
        lines += "COMPROVANTE DE APOSTA"
        lines += receipt.optString("issuedAt").replace("T", " ").take(16)
        lines += ""
        lines += "CODIGO DO RECIBO"
        lines += code
        lines += "PAGAMENTO: " + receipt.optString("paymentMethod")
        receipt.optString("customerLabel").takeIf { it.isNotBlank() }?.let { lines += "CLIENTE: $it" }
        receipt.optString("cashierLabel").takeIf { it.isNotBlank() }?.let { lines += "CAMBISTA: $it" }
        lines += "--------------------------------"
        lines += "APOSTAS"
        for (i in 0 until entries.length()) {
            val entry = entries.getJSONObject(i)
            lines += entry.optString("numberValue")
            lines += "Rodada: " + entry.optString("roundCode")
            lines += "Sorteio: " + entry.optString("resultAt").replace("T", " ").take(16)
            lines += "Unid: ${money(entry.optLong("unitCents"))} Dez: ${money(entry.optLong("tensCents"))}"
            lines += "Cent: ${money(entry.optLong("hundredsCents"))} Mil: ${money(entry.optLong("thousandsCents"))}"
            lines += "Quina: ${money(entry.optLong("quinaCents"))}"
            lines += "Valor: ${money(entry.optLong("stakeCents"))}"
            lines += ""
        }
        lines += "--------------------------------"
        lines += "TOTAL PAGO: ${money(receipt.optLong("totalCents"))}"
        lines += ""
        lines += "Guarde este comprovante."
        lines += "Consulte pelo codigo ou QR Code."

        val verificationUrl = payload.optString("verificationUrl")
        if (!verificationUrl.startsWith("https://") || verificationUrl.length > 240) {
            throw IOException("Endereço de validação do recibo inválido.")
        }

        val charset = Charset.forName("IBM860")
        val bytes = ArrayList<Byte>()
        fun add(vararg values: Int) { values.forEach { bytes.add(it.toByte()) } }
        fun addText(value: String) {
            val encoded = value.toByteArray(charset)
            encoded.forEach { bytes.add(it) }
            add(0x0A)
        }

        add(0x1B, 0x40, 0x1B, 0x74, 0x03)
        add(0x1B, 0x61, 0x01, 0x1B, 0x45, 0x01)
        addText("SUPER QUINA")
        add(0x1B, 0x45, 0x00)
        add(0x1B, 0x61, 0x00)
        lines.drop(1).forEach { addText(it) }
        add(0x0A)
        add(0x1B, 0x61, 0x01)
        qrCodeCommand(verificationUrl).forEach { bytes.add(it) }
        add(0x0A, 0x0A, 0x0A)
        return bytes.toByteArray()
    }

    private fun money(cents: Long): String {
        val safe = cents.coerceAtLeast(0)
        return "R$ ${safe / 100},${(safe % 100).toString().padStart(2, '0')}"
    }

    private fun qrCodeCommand(value: String): ByteArray {
        val data = value.toByteArray(Charsets.UTF_8)
        val bytes = ArrayList<Byte>()
        fun add(vararg values: Int) { values.forEach { bytes.add(it.toByte()) } }
        add(0x1D, 0x28, 0x6B, 4, 0, 0x31, 0x41, 0x32, 0)
        add(0x1D, 0x28, 0x6B, 3, 0, 0x31, 0x43, 6)
        add(0x1D, 0x28, 0x6B, 3, 0, 0x31, 0x45, 0x30)
        val length = data.size + 3
        add(0x1D, 0x28, 0x6B, length and 0xFF, (length shr 8) and 0xFF, 0x31, 0x50, 0x30)
        data.forEach { bytes.add(it) }
        add(0x1D, 0x28, 0x6B, 3, 0, 0x31, 0x51, 0x30)
        return bytes.toByteArray()
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
