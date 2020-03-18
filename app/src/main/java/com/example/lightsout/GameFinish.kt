package com.example.lightsout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lightsout.databinding.FragmentGameFinishBinding


class GameFinish : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameFinishBinding>(inflater,
            R.layout.fragment_game_finish,container,false)

        val score = this.arguments?.get("score").toString()
        val data = resources.getString(R.string.clicks2)

        binding.nameView.text = this.arguments?.get("name").toString()
        binding.textView3.text = "$score $data"

        binding.apply{
            retryButton.setOnClickListener{ view : View ->
                view.findNavController().navigate(R.id.action_gameFinish_to_mainGame, bundleOf("name" to binding.nameView.text))
            }
            resetName.setOnClickListener{ view : View ->
                view.findNavController().navigate(R.id.action_gameFinish_to_nameFragment)
            }
        }
        return binding.root
    }
}
