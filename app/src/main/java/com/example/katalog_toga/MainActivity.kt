package com.example.katalog_toga

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "42430001"
    }

    private lateinit var adapter: TanamanAdapter
    private val listTanaman = DataTanaman.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity: onCreate - total tanaman: ${listTanaman.size}")

        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
            WindowInsetsCompat.CONSUMED
        }

        val rvTanaman = findViewById<RecyclerView>(R.id.rvTanaman)
        val etCari = findViewById<EditText>(R.id.etCari)
        val btnSortAZ = findViewById<Button>(R.id.btnSortAZ)
        val btnSortZA = findViewById<Button>(R.id.btnSortZA)
        val layoutNotFound = findViewById<LinearLayout>(R.id.layoutNotFound)

        // Intent: perpindahan ke DetailActivity saat item diklik
        try {
            adapter = TanamanAdapter(listTanaman) { tanaman ->
                try {
                    Log.i(TAG, "MainActivity: item diklik -> ${tanaman.nama}")
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
                } catch (e: Exception) {
                    Log.e(TAG, "MainActivity: gagal membuka DetailActivity - ${e.message}", e)
                }
            }
            rvTanaman.layoutManager = GridLayoutManager(this, 2)
            rvTanaman.adapter = adapter
            Log.d(TAG, "MainActivity: RecyclerView berhasil diinisialisasi")
        } catch (e: Exception) {
            Log.e(TAG, "MainActivity: error saat inisialisasi adapter - ${e.message}", e)
        }

        // Validasi if-else pada kolom pencarian
        etCari.addTextChangedListener { text ->
            try {
                val query = text.toString().trim()
                if (query.isEmpty()) {
                    Log.i(TAG, "MainActivity: pencarian dikosongkan, tampil semua data")
                    adapter.updateData(DataTanaman.getAll())
                    rvTanaman.visibility = View.VISIBLE
                    layoutNotFound.visibility = View.GONE
                } else {
                    val hasil = DataTanaman.getAll().filter {
                        it.nama.contains(query, ignoreCase = true) ||
                        it.kategori.contains(query, ignoreCase = true)
                    }.toMutableList()
                    Log.i(TAG, "MainActivity: pencarian '$query' -> ditemukan ${hasil.size} hasil")
                    adapter.updateData(hasil)
                    if (hasil.isEmpty()) {
                        Log.i(TAG, "MainActivity: hasil pencarian kosong untuk '$query'")
                        rvTanaman.visibility = View.GONE
                        layoutNotFound.visibility = View.VISIBLE
                    } else {
                        rvTanaman.visibility = View.VISIBLE
                        layoutNotFound.visibility = View.GONE
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "MainActivity: error saat proses pencarian - ${e.message}", e)
            }
        }

        fun setSortActive(active: Button, inactive: Button) {
            active.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.green_accent))
            inactive.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.green_medium))
        }

        // Tombol Sort A→Z (Bubble Sort ascending berdasarkan nama)
        btnSortAZ.setOnClickListener {
            try {
                val data = adapter.getCurrentList().toMutableList()
                Log.i(TAG, "MainActivity: Bubble sort dimulai - urutan: A → Z")
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
                setSortActive(btnSortAZ, btnSortZA)
                Log.i(TAG, "MainActivity: Bubble sort selesai - urutan pertama: ${data.first().nama}")
            } catch (e: Exception) {
                Log.e(TAG, "MainActivity: error saat sort A→Z - ${e.message}", e)
            }
        }

        // Tombol Sort Z→A (Bubble Sort descending berdasarkan nama)
        btnSortZA.setOnClickListener {
            try {
                val data = adapter.getCurrentList().toMutableList()
                Log.i(TAG, "MainActivity: Bubble sort dimulai - urutan: Z → A")
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
                setSortActive(btnSortZA, btnSortAZ)
                Log.i(TAG, "MainActivity: Bubble sort selesai - urutan pertama: ${data.first().nama}")
            } catch (e: Exception) {
                Log.e(TAG, "MainActivity: error saat sort Z→A - ${e.message}", e)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity: onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity: onDestroy")
    }
}
