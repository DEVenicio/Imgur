package com.venicio.imgur.data.network

import com.venicio.imgur.data.model.ImgurResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImgurService {

    @GET("3/gallery/search")
    fun fetchImageAPI( @Header("Authorization") clientID: String, @Query("q") query: String) : Call<ImgurResponse>
}