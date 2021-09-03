package com.hfad.aplicforless8.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import com.hfad.aplicforless8.databinding.FragmentSettingBinding

private  const val KEY = "CHEK"
class SettingFragment : Fragment() {
    private val IS_WORLD_KEY : Boolean = false
    private var _binding : FragmentSettingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
         }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       wer()
        binding.switch18.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, boolean: Boolean) {

                getReadSettings(boolean)
            }

        })

    }
  fun  wer(){
      activity?.let {
          if (it.getPreferences(Context.MODE_PRIVATE).getBoolean(KEY, false)) {
              binding.switch18.isChecked=true
              Toast.makeText(context,"true",Toast.LENGTH_LONG).show()
          } else {
              binding.switch18.isChecked=false
              Toast.makeText(context,"false",Toast.LENGTH_LONG).show()
          }
      }
         }
    private fun getReadSettings(boolean: Boolean) {

        var setting = boolean
      val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(KEY, setting)
            apply()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }
}