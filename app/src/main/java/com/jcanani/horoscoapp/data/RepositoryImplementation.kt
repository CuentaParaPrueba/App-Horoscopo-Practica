package com.jcanani.horoscoapp.data

import android.util.Log
import com.jcanani.horoscoapp.data.network.HoroscopeApiService
import com.jcanani.horoscoapp.domain.model.PredictionModel
import com.jcanani.horoscoapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching {
            apiService.getHoroscope(sign)
        } . onSuccess {
            return it.toDomain()
        } . onFailure {
            Log.e("ERROR", "Error al traer el signo: ${it.message}")
        }
        return null
    }

}