package com.example.gameofthrones.UI.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.Adapter.HomeAdapter
import com.example.gameofthrones.DataCharacter
import com.example.gameofthrones.DataCharacterItem
import com.example.gameofthrones.Network.RetrofitForClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    init{
        Log.d("HomeViewModel", "HomeViewModel Created")
    }

    var listCharacter : ArrayList<DataCharacterItem> = arrayListOf()

    interface onClickListener{
        fun onClick(character : DataCharacterItem)
    }

    fun getDataFromAPI(recyclerView: RecyclerView, listener: onClickListener){
        RetrofitForClient.instance.getDataCharacters().enqueue(object: Callback<DataCharacter>{
            override fun onResponse(call: Call<DataCharacter>, response: Response<DataCharacter>) {
                val data = response.body()
                recyclerView.adapter = HomeAdapter(data as ArrayList<DataCharacterItem>, object : HomeAdapter.OnItemClickListener{
                    override fun onClick(character: DataCharacterItem) {
                        listener.onClick(character)
                    }

                })
            }

            override fun onFailure(call: Call<DataCharacter>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

        })
    }
}