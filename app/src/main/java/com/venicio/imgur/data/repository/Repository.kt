package com.venicio.imgur.data.repository

import com.venicio.imgur.data.utils.Constants
import com.venicio.imgur.data.model.ImgurResponse
import com.venicio.imgur.data.network.ImgurClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val service = ImgurClient.getInstanceRetrofit()

    fun getImageAPI(callback: (ImgurResponse) -> Unit) {
        val request = service.fetchImageAPI("Client-ID ${Constants.clientId}", "cats")
        request.enqueue(object : Callback<ImgurResponse>{
            override fun onResponse(call: Call<ImgurResponse>, response: Response<ImgurResponse>) {
                if (response.isSuccessful && response.code() == 200){

                    val responseData = response.body()
                    if (responseData != null) {
                        callback(responseData)
                    }
                }
            }

            override fun onFailure(call: Call<ImgurResponse>, t: Throwable) {
                //TODO implementar um tratamento para falha na request
            }
        })
    }

}

