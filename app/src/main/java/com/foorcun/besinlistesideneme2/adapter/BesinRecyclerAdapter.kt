package com.foorcun.besinlistesideneme2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.foorcun.besinlistesideneme2.R
import com.foorcun.besinlistesideneme2.model.Besin

class BesinRecyclerAdapter(val besinListesi : ArrayList<Besin>) :RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {




    class BesinViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BesinRecyclerAdapter.BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =  inflater.inflate(R.layout.besin_recycler_row,parent,false)

        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {

//        https://medium.com/@bakshiowen2010/recyclerview-in-android-kotlin-f29228c319cc
       val besinIsmiTextView =  holder.itemView.findViewById<TextView>(R.id.besinIsmi)
        besinIsmiTextView.text = besinListesi.get(position).isim
    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiGuncelle(yeniBesinListesi : List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }
}