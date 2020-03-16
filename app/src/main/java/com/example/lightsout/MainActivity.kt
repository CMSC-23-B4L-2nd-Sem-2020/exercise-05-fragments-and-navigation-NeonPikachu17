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
import com.example.lightsout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Initialization of global variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var mp: MediaPlayer
    var matrix = makeMatrix()
    var numOfClicks: Int = 0
    var numOfLights: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setVisibility()
        findViewById<Button>(R.id.done).setOnClickListener{
            setNickname(it)
            setListeners()
        }
    }

    // Part one of the exercise
    private fun setNickname(view: View) {
        // Sets the data of the textView and changes the visibility of the editable text
        binding.apply{
            test2.text = test.text
            test.visibility = View.GONE
            view.visibility = View.GONE
            test2.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE

        }

        // Removes the keyboard input
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // Makes the List for functionalization of the code
    private fun makeArray() : List<View>{
        // Puts everything into a list
        binding.apply{
            val clickBox: List<View> =
                listOf(box1, box2, box3, box4, box5, box6, box7, box8, box9, box10,
                    box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21,
                    box22, box23, box24, box25)
            return clickBox
        }

        // Returns the created List of Views
    }

    // Sets the visibility of the boxes and the retry button
    private fun setVisibility(){
        val clickBox: List<View> = makeArray()

        for(item in clickBox)  item.visibility = View.GONE

        binding.apply{
            scoreTitle.visibility = View.GONE
            textView.visibility = View.GONE
            retry.visibility = View.GONE
            textView4.visibility = View.GONE
            textView5.visibility = View.GONE
        }
    }

    // Sets the listeners of each item
    private fun setListeners() {
        val clickBox: List<View> = makeArray()
        binding.apply{
            for (item in clickBox){
                item.visibility = View.VISIBLE
                item.setOnClickListener{ changeColor( it, matrix, clickBox)
                countUp()}
            }
            setColor(clickBox, matrix)
            retry.setOnClickListener{ retry( matrix, clickBox ) }
            retry.visibility = View.VISIBLE
            scoreTitle.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
        }

    }

    // Makes the 2d array for the main function
    private fun makeMatrix(): Array<Array<Int>>{
        var arrayOfNumbers = arrayOf<Array<Int>>()

        for (i in 0..4) {
            var array = arrayOf<Int>()
            for (j in 0..4) {
                array += 1
            }
            arrayOfNumbers += array
        }

        return arrayOfNumbers
    }

    // For setting of the colors
    private fun setColor(view:List<View>, array: Array<Array<Int>>){
        // Loop for setting the color of items
        for(i in 0..4){
            for(j in 0..4){
                if(array[i][j] == 0)
                    view[(i*5)+j].setBackgroundColor(Color.BLACK)
                else
                    view[(i*5)+j].setBackgroundColor(Color.YELLOW)
            }
        }

    }

    // Checks if all lights are already turned off
    private fun checkStage(): Boolean{
        if(numOfLights == 25) return true
        return false
    }

    // Converts the index of the List to matrix view and returns the array which contains the row and column to be used by other functions
    private fun checkIndex(view:View, view2:List<View>): Array<Int>{
        val testing:Int = view2.indexOf(view)
        var index = arrayOf<Int>()

        for(i in 0..4){
            for(j in 0..4){
                if((i*5)+j == testing) {
                    index += i
                    index += j
                }
            }
        }
        return index
    }

    // Sets the colors via the matrix
    private fun changeColor(view:View, array: Array<Array<Int>>, view2:List<View>){
        val index = checkIndex(view, view2)
        val row: Int = index[0]
        val col: Int = index[1]

        if(array[row][col] == 1){
            array[row][col] = 0
            numOfLights++
        }
        else{
            array[row][col] = 1
            numOfLights--
        }

        // For the different cases of items
        if((row-1) != -1 && (row+1) != 5){
            if(array[row-1][col] == 1){
                array[row-1][col] = 0
                numOfLights++
            }
            else {
                array[row-1][col] = 1
                numOfLights--
            }
            if (array[row+1][col] == 1){
                array[row+1][col] = 0
                numOfLights++
            }
            else{
                array[row+1][col] = 1
                numOfLights--
            }
        } else if((row-1) == -1){
            if(array[row+1][col] == 1){
                array[row+1][col] = 0
                numOfLights++
            }
            else{
                array[row+1][col] = 1
                numOfLights--
            }
        } else{
            if(array[row-1][col] == 1){
                array[row-1][col] = 0
                numOfLights++
            }
            else{
                array[row-1][col] = 1
                numOfLights--
            }
        }

        if((col-1) != -1 && (col+1) != 5){
            if(array[row][col-1] == 1){
                array[row][col-1] = 0
                numOfLights++
            }
            else{
                array[row][col-1] = 1
                numOfLights--
            }
            if(array[row][col+1] == 1){
                array[row][col+1] = 0
                numOfLights++
            }
            else{
                array[row][col+1] = 1
                numOfLights--
            }
        } else if((col-1) == -1){
            if(array[row][col+1] == 1){
                array[row][col+1] = 0
                numOfLights++
            }
            else{
                array[row][col+1] = 1
                numOfLights--
            }
        } else{
            if(array[row][col-1] == 1){
                array[row][col-1] = 0
                numOfLights++
            }
            else{
                array[row][col-1] = 1
                numOfLights--
            }
        }

        setColor(view2, array)
    }

    // For function of the retry button
    private fun retry(array: Array<Array<Int>>, view2:List<View>){
        val click: TextView = findViewById(R.id.textView)

        for(i in 0..4) for(j in 0..4)array[i][j] = 1
        setColor(view2, array)
        for(item in view2) item.visibility = View.VISIBLE
        numOfClicks = 0
        numOfLights = 0
        click.text = numOfClicks.toString()
    }

    // For checking of number of clicks
     fun countUp(){
        val click: TextView = findViewById(R.id.textView)
        numOfClicks++
        click.text = numOfClicks.toString()
    }


}