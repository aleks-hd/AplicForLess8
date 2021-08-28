package com.hfad.aplicforless8.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hfad.aplicforless8.AppState
import com.hfad.aplicforless8.databinding.FragmentMainBinding
import com.hfad.aplicforless8.model.Films
import com.hfad.aplicforless8.model.ResulltFilm

import com.hfad.aplicforless8.viewmodel.MainViewModel


class MainFragment : Fragment() {

    private var viewModel: MainViewModel = MainViewModel()
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    viewModel.getLiveData().observe(viewLifecycleOwner, Observer { render(it) })

        binding.sendToServer.setOnClickListener {
            viewModel.getDataFromServer()
        }

    }

    private fun render(it: AppState?) {
        when(it){
           is AppState.Success -> {
               val listFilms = it.listFilms
               setData(listFilms)
           }
        }
    }

    private fun setData(listFilms: List<Films>?) {
        val idFilm = listFilms?.get(1) as ResulltFilm
        binding.idFilm.text = idFilm?.id.toString()
        binding.titleFilm.text = idFilm?.title.toString()

    }

    companion object {
       fun newInstance() =MainFragment()
    }
}