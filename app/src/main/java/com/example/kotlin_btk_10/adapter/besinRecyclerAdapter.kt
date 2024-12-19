package com.example.kotlin_btk_10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_btk_10.databinding.BesinRecyclerRowBinding
import com.example.kotlin_btk_10.model.Besindata
import com.example.kotlin_btk_10.util.gorselIndir
import com.example.kotlin_btk_10.util.placeHolderYap
import com.example.kotlin_btk_10.view.besinListeFragmentDirections

class besinRecyclerAdapter (val besinListesi : ArrayList<Besindata>): RecyclerView.Adapter<besinRecyclerAdapter.BesinViewHolder>()   {
    class BesinViewHolder(val binding: BesinRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {

        val binding = BesinRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BesinViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return besinListesi.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi: List<Besindata>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {

        holder.binding.isim.text = besinListesi[position].isim
        holder.binding.kalori.text = besinListesi[position].kalori

        holder.itemView.setOnClickListener {
            val action = besinListeFragmentDirections.actionBesinListeFragmentToBesinDetayFragment(besinListesi[position].uuid)
            Navigation.findNavController(it).navigate(action)

        }

        holder.binding.imageView.gorselIndir(besinListesi[position].gorsel, placeHolderYap(holder.itemView.context))

    }
}