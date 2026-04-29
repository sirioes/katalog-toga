package com.example.katalog_toga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TanamanAdapter
    private val listTanaman = DataTanaman.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTanaman = findViewById<RecyclerView>(R.id.rvTanaman)
        val etCari = findViewById<EditText>(R.id.etCari)
        val btnSortAZ = findViewById<Button>(R.id.btnSortAZ)
        val btnSortZA = findViewById<Button>(R.id.btnSortZA)
        val layoutNotFound = findViewById<LinearLayout>(R.id.layoutNotFound)

        // Intent: perpindahan ke DetailActivity saat item diklik
        adapter = TanamanAdapter(listTanaman) { tanaman ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("NAMA", tanaman.nama)
                putExtra("NAMA_LATIN", tanaman.namaLatin)
                putExtra("EMOJI", tanaman.emoji)
                putExtra("KATEGORI", tanaman.kategori)
                putExtra("ASAL", tanaman.asal)
                putExtra("MANFAAT", tanaman.manfaat)
                putExtra("BAGIAN", tanaman.bagian)
                putExtra("CARA", tanaman.caraPenggunaan)
                putExtra("PERINGATAN", tanaman.peringatan)
            }
            startActivity(intent)
        }
        rvTanaman.layoutManager = GridLayoutManager(this, 2)
        rvTanaman.adapter = adapter

        // Validasi if-else pada kolom pencarian
        etCari.addTextChangedListener { text ->
            val query = text.toString().trim()
            if (query.isEmpty()) {
                adapter.updateData(DataTanaman.getAll())
                rvTanaman.visibility = View.VISIBLE
                layoutNotFound.visibility = View.GONE
            } else {
                val hasil = DataTanaman.getAll().filter {
                    it.nama.contains(query, ignoreCase = true) ||
                    it.kategori.contains(query, ignoreCase = true)
                }.toMutableList()
                adapter.updateData(hasil)
                if (hasil.isEmpty()) {
                    rvTanaman.visibility = View.GONE
                    layoutNotFound.visibility = View.VISIBLE
                } else {
                    rvTanaman.visibility = View.VISIBLE
                    layoutNotFound.visibility = View.GONE
                }
            }
        }

        // Tombol Sort A→Z (Bubble Sort ascending berdasarkan nama)
        btnSortAZ.setOnClickListener {
            val data = adapter.getCurrentList()
            for (i in 0 until data.size - 1) {
                for (j in 0 until data.size - 1 - i) {
                    if (data[j].nama > data[j + 1].nama) {
                        val temp = data[j]
                        data[j] = data[j + 1]
                        data[j + 1] = temp
                    }
                }
            }
            adapter.updateData(data)
        }

        // Tombol Sort Z→A (Bubble Sort descending berdasarkan nama)
        btnSortZA.setOnClickListener {
            val data = adapter.getCurrentList()
            for (i in 0 until data.size - 1) {
                for (j in 0 until data.size - 1 - i) {
                    if (data[j].nama < data[j + 1].nama) {
                        val temp = data[j]
                        data[j] = data[j + 1]
                        data[j + 1] = temp
                    }
                }
            }
            adapter.updateData(data)
        }
    }
}
