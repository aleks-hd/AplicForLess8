package com.hfad.aplicforless8.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import com.hfad.aplicforless8.databinding.FragmentInfoBinding
import com.hfad.aplicforless8.model.ResulltFilm


class InfoFragment(film: ResulltFilm) : Fragment(){


    private var _binding : FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private var cardFilm = film

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        openCardFilm(cardFilm)
    }

    fun openCardFilm(resulltFilm : ResulltFilm){
        binding.idFilm.text = resulltFilm.id.toString()
        binding.nameFilm.text = resulltFilm.title.toString()
        binding.despriptionFilm.text = resulltFilm.overview.toString()
       val pictures = resulltFilm.poster_path.toString()
        binding.imageViewContainer.load("https://image.tmdb.org/t/p/w200${pictures}")
    }

   /* companion object {
        fun newInstance() =InfoFragment()
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}