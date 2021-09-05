package com.hfad.aplicforless8.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.aplicforless8.R
import com.hfad.aplicforless8.databinding.FragmentMenuBinding


class MenuFragment : Fragment(){

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.home.setOnClickListener {
            openMainFragment()
        }
        binding.like.setOnClickListener {
            openLikeFragment()
        }
        binding.info.setOnClickListener {
           openContactFragment()
        }
    }


    private fun openMainFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_container_fragment, MainFragment.newInstance())
            ?.commit()
    }

    private fun openLikeFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_container_fragment, LikeFragment.newInstance())
            ?.commit()
    }

    private fun openContactFragment() {

        activity?.supportFragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_container_fragment, ContFragment.newInstance())
            ?.commit()
    }

    companion object {
        fun newInstance() = MenuFragment()
    }




}