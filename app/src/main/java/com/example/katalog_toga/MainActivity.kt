package com.example.katalog_toga

import android.content.Intent
import android.os.Bundle
// import android.widget.Button
// import android.widget.EditText
// import androidx.core.widget.addTextChangedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TanamanAdapter
    private val listTanaman = DataTanaman.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTanaman = findViewById<RecyclerView>(R.id.rvTanaman)

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

        // =====================================================
        // FITUR BELUM AKTIF
        // =====================================================

        // val etCari = findViewById<EditText>(R.id.etCari)
        // val btnSortAZ = findViewById<Button>(R.id.btnSortAZ)
        // val btnSortZA = findViewById<Button>(R.id.btnSortZA)

        // Validasi if-else pada kolom pencarian
        // etCari.addTextChangedListener { text ->
        //     val query = text.toString().trim()
        //     if (query.isEmpty()) {
        //         adapter.updateData(DataTanaman.getAll())
        //     } else {
        //         val hasil = DataTanaman.getAll().filter {
        //             it.nama.contains(query, ignoreCase = true) ||
        //             it.kategori.contains(query, ignoreCase = true)
        //         }.toMutableList()
        //         adapter.updateData(hasil)
        //     }
        // }

        // Tombol Sort A→Z
        // btnSortAZ.setOnClickListener {
        //     val sorted = adapter.getCurrentList().sortedBy { it.nama }.toMutableList()
        //     adapter.updateData(sorted)
        // }

        // Tombol Sort Z→A
        // btnSortZA.setOnClickListener {
        //     val sorted = adapter.getCurrentList().sortedByDescending { it.nama }.toMutableList()
        //     adapter.updateData(sorted)
        // }
    }
}