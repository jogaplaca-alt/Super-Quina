package com.supersena.impressora
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
object EscPosHelper {
 private val charset: Charset by lazy { runCatching { Charset.forName("CP860") }.getOrElse { Charset.forName("ISO-8859-1") } }
 enum class Alignment { LEFT, CENTER, RIGHT }
 fun buildTestPrint(userText:String,dateTime:String):ByteArray {
  val o=ByteArrayOutputStream()
  o.write(byteArrayOf(0x1B,0x40)); o.write(byteArrayOf(0x1B,0x74,0x03))
  o.write(bold(true)); o.write(alignment(Alignment.CENTER)); o.write(text("TESTE DE IMPRESSAO\n"))
  o.write(bold(false)); o.write(text("--------------------------------\n")); o.write(alignment(Alignment.LEFT))
  o.write(text(userText.trim().ifBlank { "Teste de impressao Bluetooth." })); o.write(text("\n\n"))
  o.write(alignment(Alignment.CENTER)); o.write(text("Data/Hora: $dateTime\n"))
  o.write(feedLines(4)); o.write(partialCut()); return o.toByteArray()
 }
 fun text(s:String)=s.toByteArray(charset)
 fun alignment(a:Alignment)=byteArrayOf(0x1B,0x61,when(a){Alignment.LEFT->0;Alignment.CENTER->1;Alignment.RIGHT->2})
 fun bold(on:Boolean)=byteArrayOf(0x1B,0x45,if(on) 1 else 0)
 fun doubleSize(on:Boolean)=byteArrayOf(0x1D,0x21,if(on) 0x11 else 0)
 fun feedLines(n:Int=4)=byteArrayOf(0x1B,0x64,n.coerceIn(0,255).toByte())
 fun partialCut()=byteArrayOf(0x1D,0x56,0x41,0x10)
}