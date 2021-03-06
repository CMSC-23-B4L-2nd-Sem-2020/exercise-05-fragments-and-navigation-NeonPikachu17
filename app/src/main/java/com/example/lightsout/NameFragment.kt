package com.example.lightsout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lightsout.databinding.FragmentNameBinding


class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentNameBinding>(inflater,
            R.layout.fragment_name,container,false)
        binding.playButton.setOnClickListener { view : View ->
            // Shift to other fragment + passes the "name" value to the other fragment so that it is accessible to the fragment
            view.findNavController().navigate(R.id.action_nameFragment_to_mainGame, bundleOf("name" to binding.nameText.text) )
        }

        return binding.root
    }

}
