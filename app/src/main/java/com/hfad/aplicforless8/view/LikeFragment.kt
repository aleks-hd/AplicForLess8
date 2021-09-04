package com.hfad.aplicforless8.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.aplicforless8.databinding.FragmentLikeBinding

import com.hfad.aplicforless8.model.ResulltFilm
import com.hfad.aplicforless8.model.adaptehistory.HistAdapter
import com.hfad.aplicforless8.viewmodel.AppState
import com.hfad.aplicforless8.viewmodel.DetailtViewModel


class LikeFragment : Fragment() {

    private var viewModelDetail: DetailtViewModel = DetailtViewModel()
    var listFilmDB: List<ResulltFilm> = listOf()
    private val adapter = HistAdapter()
    private var _binding: FragmentLikeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.containerLocalDBRecycler.adapter = adapter
        binding.containerLocalDBRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        viewModelDetail.getLiveData().observe(viewLifecycleOwner, Observer {
            render(it)
        })
        viewModelDetail.getAllHistory()
    }

    private fun render(it: AppState?) {
        when (it) {
            is AppState.SuccessLocal -> {
                var films = it.listFilm
                setData(films)
            }
        }
    }

    private fun setData(films: List<ResulltFilm>) {
       adapter.setData(films)

    }


    companion object {
      fun newInstance() = LikeFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}