package com.example.fotosdemarte.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MarPhoto(
    val id: String,
    @SerialName(value = "img_src") val imgString: String
) {
}