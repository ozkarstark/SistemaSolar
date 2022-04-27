package com.example.sistemasolar.planetlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Data
import com.example.example.Root
import com.example.sistemasolar.R
import kotlinx.android.synthetic.main.card_planet_search.view.*


class PlanetListAdapter(val planetClick:(Int)-> Unit): RecyclerView.Adapter<PlanetListAdapter.SearchViewHolder>() {
    var planetList: List<Data> = emptyList<Data>()

    fun setData(list: List<Data>){
        planetList= list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_planet_search,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon=planetList[position]

        holder.itemView.planetText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { planetClick(position+1) }
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}
