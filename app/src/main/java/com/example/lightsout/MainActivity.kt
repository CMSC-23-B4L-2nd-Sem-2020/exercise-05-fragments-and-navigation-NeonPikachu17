package com.example.lightsout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done).setOnClickListener{
            setNickname(it)
        }
        setListeners()
    }

    // Part one of the exercise
    private fun setNickname(view: View) {
        // Initializing of the variables in terms of getting the id of the nickname
        val editText = findViewById<EditText>(R.id.test)
        val textView = findViewById<TextView>(R.id.test2)

        // Sets the data of the textView and changes the visibility of the editable text
        textView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        textView.visibility = View.VISIBLE

        // Removes the keyboard input
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun setListeners() {

        var arrayN = arrayOf<Int>()
        for (j in 0..4) {
            arrayN =
        }
    }
}
