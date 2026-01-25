package com.jcanani.horoscoapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.jcanani.horoscoapp.databinding.ItemHoroscopeBinding
import com.jcanani.horoscoapp.domain.model.HoroscopoInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvNameHoroscope.text = binding.tvNameHoroscope.context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLanda = { onItemSelected(horoscopeInfo) })
            //onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnimation(view: View, newLanda:()->Unit) {
        view.animate().apply {
            duration = 500
            withEndAction { newLanda() }
            interpolator = LinearInterpolator()
            rotationBy(360f)
            start()
        }
    }

}