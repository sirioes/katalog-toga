package com.example.katalog_toga

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "42430001"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowInsetsCompat.CONSUMED
        }

        try {
            val nama = intent.getStringExtra("NAMA") ?: ""
            val namaLatin = intent.getStringExtra("NAMA_LATIN") ?: ""
            val emoji = intent.getStringExtra("EMOJI") ?: ""
            val kategori = intent.getStringExtra("KATEGORI") ?: ""
            val asal = intent.getStringExtra("ASAL") ?: ""
            val manfaat = intent.getStringExtra("MANFAAT") ?: ""
            val bagian = intent.getStringExtra("BAGIAN") ?: ""
            val cara = intent.getStringExtra("CARA") ?: ""
            val peringatan = intent.getStringExtra("PERINGATAN") ?: ""

            Log.i(TAG, "DetailActivity: onCreate - menampilkan detail '$nama'")

            findViewById<TextView>(R.id.tvNamaDetail).text = nama
            findViewById<TextView>(R.id.tvNamaLatinDetail).text = namaLatin
            findViewById<TextView>(R.id.tvEmojiDetail).text = emoji
            findViewById<TextView>(R.id.tvKategoriDetail).text = kategori
            findViewById<TextView>(R.id.tvAsal).text = "📍 $asal"
            findViewById<TextView>(R.id.tvManfaat).text = manfaat
            findViewById<TextView>(R.id.tvBagianPakai).text = bagian
            findViewById<TextView>(R.id.tvCaraPenggunaan).text = cara
            findViewById<TextView>(R.id.tvPeringatan).text = peringatan

            Log.d(TAG, "DetailActivity: semua data berhasil ditampilkan untuk '$nama'")
        } catch (e: Exception) {
            Log.e(TAG, "DetailActivity: error saat menampilkan data - ${e.message}", e)
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            Log.i(TAG, "DetailActivity: tombol kembali ditekan")
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "DetailActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "DetailActivity: onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "DetailActivity: onDestroy")
    }
}