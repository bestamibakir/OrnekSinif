package com.bestamibakir.orneksinif

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bestamibakir.orneksinif.databinding.ActivityMainBinding
import com.bestamibakir.orneksinif.databinding.RecyclerRowBinding

class OrnekSinifAdapter(val ornekSinifListesi : ArrayList<OrnekSinif>) : RecyclerView.Adapter<OrnekSinifAdapter.OrnekSinifViewHolder>(){
    class OrnekSinifViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrnekSinifViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrnekSinifViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ornekSinifListesi.size
    }

    override fun onBindViewHolder(holder: OrnekSinifViewHolder, position: Int) {
        holder.binding.recyclerRowTextView.text = ornekSinifListesi[position].isim

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,SecondActivity::class.java)
            intent.putExtra("ornekSinifIleAl",ornekSinifListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}