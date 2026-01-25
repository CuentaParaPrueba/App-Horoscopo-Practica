package com.jcanani.horoscoapp.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.jcanani.horoscoapp.data.providers.HoroscopeProvider
import com.jcanani.horoscoapp.domain.model.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {
    
    private var _horoscope = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopoInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }
    
}