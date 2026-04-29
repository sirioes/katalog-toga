package com.example.katalog_toga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TanamanAdapter(
    private var list: MutableList<Tanaman>,
    private val onClick: (Tanaman) -> Unit
) : RecyclerView.Adapter<TanamanAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEmoji: TextView = view.findViewById(R.id.tvEmoji)
        val tvNama: TextView = view.findViewById(R.id.tvNama)
        val tvNamaLatin: TextView = view.findViewById(R.id.tvNamaLatin)
        val tvKategori: TextView = view.findViewById(R.id.tvKategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tanaman, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val t = list[position]
        holder.tvEmoji.text = t.emoji
        holder.tvNama.text = t.nama
        holder.tvNamaLatin.text = t.namaLatin
        holder.tvKategori.text = t.kategori
        holder.itemView.setOnClickListener { onClick(t) }
    }

    override fun getItemCount() = list.size

    fun updateData(newList: MutableList<Tanaman>) {
        list = newList
        notifyDataSetChanged()
    }

    fun getCurrentList(): MutableList<Tanaman> = list
}