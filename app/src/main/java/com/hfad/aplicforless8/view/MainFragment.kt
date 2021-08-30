package com.hfad.aplicforless8.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.aplicforless8.MainAdapter
import com.hfad.aplicforless8.R
import com.hfad.aplicforless8.viewmodel.AppState
import com.hfad.aplicforless8.databinding.FragmentMainBinding
import com.hfad.aplicforless8.model.Films
import com.hfad.aplicforless8.model.ResulltFilm

import com.hfad.aplicforless8.viewmodel.MainViewModel


class MainFragment : Fragment() {

    private var viewModel: MainViewModel = MainViewModel()
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

     var listFilm : List<ResulltFilm> = listOf()
    private var adapter = MainAdapter()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    viewModel.getLiveData().observe(viewLifecycleOwner, Observer { render(it) })
        binding.recyclerContainer.adapter = adapter
        binding.recyclerContainer.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        adapter.setOnClickListener(object : MainAdapter.ClickEventHandler{
            override fun forwardClick(film: ResulltFilm) {
                var filmk = film
                activity?.supportFragmentManager?.beginTransaction()
                    ?.addToBackStack(null)
                    ?.replace(R.id.main_container_fragment, InfoFragment(filmk))
                    ?.commit()
            }

        })
        viewModel.getDataFromServer()
        binding.sendToServer.setOnClickListener {
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
//array
    private fun setData(listFilms1: Films?) {

        val idFilm = listFilms1?.results
    if (idFilm != null) {
        listFilm = idFilm
        adapter.setFilms(listFilm)
    }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
       fun newInstance() =MainFragment()
    }




}