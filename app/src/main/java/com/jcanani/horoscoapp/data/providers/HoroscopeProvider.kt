package com.jcanani.horoscoapp.data.providers

import com.jcanani.horoscoapp.domain.model.HoroscopoInfo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){

    fun getHoroscope () : List<HoroscopoInfo> {
        return listOf(
            HoroscopoInfo.Aries,
            HoroscopoInfo.Taurus,
            HoroscopoInfo.Gemini,
            HoroscopoInfo.Cancer,
            HoroscopoInfo.Leo,
            HoroscopoInfo.Virgo,
            HoroscopoInfo.Libra,
            HoroscopoInfo.Scorpio,
            HoroscopoInfo.Sagittarius,
            HoroscopoInfo.Capricorn,
            HoroscopoInfo.Aquarius,
            HoroscopoInfo.Pisces,
        )
    }

}