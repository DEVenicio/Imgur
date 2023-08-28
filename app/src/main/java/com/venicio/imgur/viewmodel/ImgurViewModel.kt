package com.venicio.imgur.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.venicio.imgur.data.repository.Repository
import com.venicio.imgur.data.model.Image

class ImgurViewModel(private val repository: Repository) : ViewModel() {

    private val _imagesAPI = MutableLiveData<List<Image>>()
    val imagesAPI: LiveData<List<Image>> get() = _imagesAPI

    init {
        getImage()
    }

    private fun getImage() {
        repository.getImageAPI { response ->

            val listImages = mutableListOf<Image>()

            for (data in response.data) {
                if (data != null) {
                    for (image in data.images) {
                        image.let { imageItem ->
                            if (imageItem != null) {
                                listImages.add(imageItem)
                            }
                        }
                    }
                }
            }
            _imagesAPI.postValue(listImages)
        }
    }

}