package com.example.individual3m6

import com.google.gson.annotations.SerializedName

data class RealEstate(
    @SerializedName("price") val price: Int,
    @SerializedName("id") val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("img_src") val imgSrc: String
)