package com.venicio.imgur.data.network

import com.google.gson.Gson
import com.venicio.imgur.data.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ImgurClient {
    private val gson = Gson().newBuilder().create()

    fun getInstanceRetrofit() : ImgurService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(ImgurService::class.java)
    }

}