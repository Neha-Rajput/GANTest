package com.example.gantestapplication.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    //CREATE HTTP CLIENT
    val okHttp = OkHttpClient.Builder()

    //retrofit builder
    val builder = Retrofit.Builder().baseUrl("https://breakingbadapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }


}