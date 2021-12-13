package com.example.gameofthrones.Network

import com.example.gameofthrones.DataCharacter
import retrofit2.Call
import retrofit2.http.GET

interface APIEndPoint {

    @GET("api/v2/characters")
    fun getDataCharacters() : Call<DataCharacter>
}