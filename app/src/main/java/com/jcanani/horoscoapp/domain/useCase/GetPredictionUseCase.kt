package com.jcanani.horoscoapp.domain.useCase

import com.jcanani.horoscoapp.domain.repository.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)


}