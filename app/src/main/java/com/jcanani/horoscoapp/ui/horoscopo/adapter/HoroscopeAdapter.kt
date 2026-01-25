package com.jcanani.horoscoapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcanani.horoscoapp.R
import com.jcanani.horoscoapp.domain.model.HoroscopoInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopoInfo> = emptyList(),
    private val onItemSelected:(HoroscopoInfo) -> Unit): RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopoInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: HoroscopeViewHolder,
        position: Int
    ) {
        holder.render(horoscopeList[position], onItemSelected)
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }
}