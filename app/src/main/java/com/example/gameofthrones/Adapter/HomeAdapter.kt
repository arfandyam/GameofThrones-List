package com.example.gameofthrones.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.DataCharacterItem
import com.example.gameofthrones.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.home_itemlist.view.*

class HomeAdapter(private val listCharacter : ArrayList<DataCharacterItem>, val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    interface OnItemClickListener{
        fun onClick(character: DataCharacterItem)
    }

    class Homeholder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(character : DataCharacterItem, listener: OnItemClickListener){
            with(itemView){
                Picasso.get()
                    .load(character.imageUrl)
                    .into(character_img)
                namatv.text = character.fullName
                familytv.text = "Family: " + character.family

                itemView.setOnClickListener{
                    listener.onClick(character)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Homeholder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.home_itemlist, parent, false)
        return Homeholder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.Homeholder, position: Int) {
        holder.bind(listCharacter[position], listener)
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

}