package com.jcanani.horoscoapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.jcanani.horoscoapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    //@SerializedName("icon") val icon: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}