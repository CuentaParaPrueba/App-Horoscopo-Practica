package com.jcanani.horoscoapp.domain.repository

import com.jcanani.horoscoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}