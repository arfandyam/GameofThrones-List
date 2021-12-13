package com.example.gameofthrones.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitForClient {

    val url_base = "https://thronesapi.com/"

    val instance : APIEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(url_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APIEndPoint::class.java)
    }
}