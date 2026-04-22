package com.example.katalog_toga

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<TextView>(R.id.tvNamaDetail).text = intent.getStringExtra("NAMA")
        findViewById<TextView>(R.id.tvNamaLatinDetail).text = intent.getStringExtra("NAMA_LATIN")
        findViewById<TextView>(R.id.tvEmojiDetail).text = intent.getStringExtra("EMOJI")
        findViewById<TextView>(R.id.tvKategoriDetail).text = intent.getStringExtra("KATEGORI")
        findViewById<TextView>(R.id.tvAsal).text = "📍 ${intent.getStringExtra("ASAL")}"
        findViewById<TextView>(R.id.tvManfaat).text = intent.getStringExtra("MANFAAT")
        findViewById<TextView>(R.id.tvBagianPakai).text = intent.getStringExtra("BAGIAN")
        findViewById<TextView>(R.id.tvCaraPenggunaan).text = intent.getStringExtra("CARA")
        findViewById<TextView>(R.id.tvPeringatan).text = intent.getStringExtra("PERINGATAN")

        findViewById<Button>(R.id.btnBack).setOnClickListener { finish() }
    }
}