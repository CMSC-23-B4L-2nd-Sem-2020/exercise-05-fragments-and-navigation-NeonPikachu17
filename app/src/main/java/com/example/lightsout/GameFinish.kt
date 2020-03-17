package com.example.lightsout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lightsout.databinding.FragmentGameFinishBinding


class GameFinish : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameFinishBinding>(inflater,
            R.layout.fragment_game_finish,container,false)
        return binding.root
    }
}
