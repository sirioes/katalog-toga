package com.example.katalog_toga

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TanamanAdapter(
    private var list: MutableList<Tanaman>,
    private val onClick: (Tanaman) -> Unit
) : RecyclerView.Adapter<TanamanAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "42430001"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEmoji: TextView = view.findViewById(R.id.tvEmoji)
        val tvNama: TextView = view.findViewById(R.id.tvNama)
        val tvNamaLatin: TextView = view.findViewById(R.id.tvNamaLatin)
        val tvKategori: TextView = view.findViewById(R.id.tvKategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return try {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tanaman, parent, false)
            Log.d(TAG, "TanamanAdapter: ViewHolder berhasil dibuat")
            ViewHolder(view)
        } catch (e: Exception) {
            Log.e(TAG, "TanamanAdapter: gagal membuat ViewHolder - ${e.message}", e)
            throw e
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            val t = list[position]
            holder.tvEmoji.text = t.emoji
            holder.tvNama.text = t.nama
            holder.tvNamaLatin.text = t.namaLatin
            holder.tvKategori.text = t.kategori
            holder.itemView.setOnClickListener { onClick(t) }
            Log.d(TAG, "TanamanAdapter: bind item[$position] -> ${t.nama}")
        } catch (e: Exception) {
            Log.e(TAG, "TanamanAdapter: error saat bind item[$position] - ${e.message}", e)
        }
    }

    override fun getItemCount() = list.size

    fun updateData(newList: MutableList<Tanaman>) {
        list = newList
        notifyDataSetChanged()
        Log.d(TAG, "TanamanAdapter: data diperbarui, total: ${newList.size} item")
    }

    fun getCurrentList(): MutableList<Tanaman> = list.toMutableList()
}