package br.com.superquina.printer

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.util.Base64
import android.widget.Toast
import org.json.JSONObject

/**
 * Receives an explicit, user-initiated print request from the website.
 *
 * Protocol: superquina-printer://print?payload=<base64url(JSON)>
 * This receiver validates the envelope only. Bluetooth transmission and the
 * production receipt schema are implemented in subsequent milestones.
 */
class PrintRequestActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleRequest(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleRequest(intent)
    }

    private fun handleRequest(request: Intent?) {
        val uri: Uri? = request?.data
        if (request?.action != Intent.ACTION_VIEW ||
            uri?.scheme != "superquina-printer" ||
            uri.host != "print"
        ) {
            finish()
            return
        }

        val encoded = uri.getQueryParameter("payload")
        if (encoded.isNullOrBlank() || encoded.length > MAX_ENCODED_PAYLOAD) {
            Toast.makeText(this, "Solicitação de impressão inválida.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        try {
            val bytes = Base64.decode(encoded, Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING)
            val json = JSONObject(bytes.toString(Charsets.UTF_8))
            if (json.optString("version") != "1" || json.optString("jobId").isBlank()) {
                throw IllegalArgumentException("Invalid receipt envelope")
            }

            // TODO: pass validated receipt to PrinterController.
            // Never print arbitrary HTML or trust caller-supplied printer commands.
            Toast.makeText(this, "Recibo recebido. Integração Bluetooth em desenvolvimento.", Toast.LENGTH_LONG).show()
        } catch (_: Exception) {
            Toast.makeText(this, "Não foi possível interpretar o recibo.", Toast.LENGTH_LONG).show()
        } finally {
            finish()
        }
    }

    companion object {
        private const val MAX_ENCODED_PAYLOAD = 48_000
    }
}
