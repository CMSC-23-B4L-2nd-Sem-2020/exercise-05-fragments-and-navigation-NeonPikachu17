package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lightsout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    // TODO (01) Create the new TitleFragment
    // Select File->New->Fragment->Fragment (Blank)

    // TODO (02) Clean up the new TitleFragment
    // In our new TitleFragment

    // TODO (03) Use DataBindingUtil.inflate to inflate and return the titleFragment in onCreateView
    // In our new TitleFragment
    // R.layout.fragment_title
}




