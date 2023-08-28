package com.venicio.imgur.data.model

data class ImgurResponse(
    val data: List<DataImages?>,
    val status: Int,
    val success: Boolean
)

data class DataImages(
    val images: List<Image?>
)

data class Image(
    val id: String?,
    val link: String?,
)