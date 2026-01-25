package com.jcanani.horoscoapp.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcanani.horoscoapp.databinding.FragmentHoroscopoBinding
import com.jcanani.horoscoapp.domain.model.HoroscopeModel
import com.jcanani.horoscoapp.domain.model.HoroscopoInfo
import com.jcanani.horoscoapp.ui.horoscopo.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewodel by viewModels<HoroscopoViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    // primer metodo creado
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    // segundo metodo creado
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            //Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()

            val type: HoroscopeModel = when(it) {
                HoroscopoInfo.Aquarius -> HoroscopeModel.Aquarius
                HoroscopoInfo.Aries -> HoroscopeModel.Aries
                HoroscopoInfo.Gemini -> HoroscopeModel.Gemini
                HoroscopoInfo.Cancer -> HoroscopeModel.Cancer
                HoroscopoInfo.Capricorn -> HoroscopeModel.Capricorn
                HoroscopoInfo.Leo -> HoroscopeModel.Leo
                HoroscopoInfo.Libra -> HoroscopeModel.Libra
                HoroscopoInfo.Pisces -> HoroscopeModel.Pisces
                HoroscopoInfo.Sagittarius -> HoroscopeModel.Sagittarius
                HoroscopoInfo.Scorpio -> HoroscopeModel.Scorpio
                HoroscopoInfo.Taurus -> HoroscopeModel.Taurus
                HoroscopoInfo.Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopeDetailActivity(type)
            )
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewodel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }
}