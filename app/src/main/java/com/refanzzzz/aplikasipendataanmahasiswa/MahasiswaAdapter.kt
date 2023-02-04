package com.refanzzzz.aplikasipendataanmahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val dataMahasiswa: List<Mahasiswa>) : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtNIM: TextView = itemView.findViewById(R.id.tvNIMMahasiswa)
        private val txtNama: TextView = itemView.findViewById(R.id.tvNamaMahasiswa)

        fun bind(data:Mahasiswa) {
            txtNIM.text = data.nim
            txtNama.text = data.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mahasiswa_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataMahasiswa[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataMahasiswa.size
    }

}