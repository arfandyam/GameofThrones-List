package com.example.gameofthrones.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.DataCharacterItem
import com.example.gameofthrones.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_itemlist.view.*

class HomeAdapter(private val listCharacter : ArrayList<DataCharacterItem>) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    class Homeholder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(character : DataCharacterItem){
            with(itemView){
                Picasso.get()
                    .load(character.imageUrl)
                    .into(character_img)
                namatv.text = character.fullName
                familytv.text = "Family: " + character.family
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Homeholder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.home_itemlist, parent, false)
        return Homeholder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.Homeholder, position: Int) {
        holder.bind(listCharacter[position])
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

}