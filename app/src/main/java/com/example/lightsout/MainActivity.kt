package com.example.lightsout

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mine = makeMatrix()
    var numOfClicks: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setVisibility()
        findViewById<Button>(R.id.done).setOnClickListener{
            setNickname(it)
            setListeners()
        }
    }

    // Part one of the exercise
    private fun setNickname(view: View) {
        // Initializing of the variables in terms of getting the id of the nickname
        val editText = findViewById<EditText>(R.id.test)
        val textView = findViewById<TextView>(R.id.test2)
        val textView2 = findViewById<TextView>(R.id.textView4)

        // Sets the data of the textView and changes the visibility of the editable text
        textView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        textView.visibility = View.VISIBLE
        textView2.visibility = View.VISIBLE

        // Removes the keyboard input
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // Makes the List for functionalization of the code
    private fun makeArray() : List<View>{
        val box1 = findViewById<TextView>(R.id.box1)
        val box2 = findViewById<TextView>(R.id.box2)
        val box3 = findViewById<TextView>(R.id.box3)
        val box4 = findViewById<TextView>(R.id.box4)
        val box5 = findViewById<TextView>(R.id.box5)
        val box6 = findViewById<TextView>(R.id.box6)
        val box7 = findViewById<TextView>(R.id.box7)
        val box8 = findViewById<TextView>(R.id.box8)
        val box9 = findViewById<TextView>(R.id.box9)
        val box10 = findViewById<TextView>(R.id.box10)
        val box11 = findViewById<TextView>(R.id.box11)
        val box12 = findViewById<TextView>(R.id.box12)
        val box13 = findViewById<TextView>(R.id.box13)
        val box14 = findViewById<TextView>(R.id.box14)
        val box15 = findViewById<TextView>(R.id.box15)
        val box16 = findViewById<TextView>(R.id.box16)
        val box17 = findViewById<TextView>(R.id.box17)
        val box18 = findViewById<TextView>(R.id.box18)
        val box19 = findViewById<TextView>(R.id.box19)
        val box20 = findViewById<TextView>(R.id.box20)
        val box21 = findViewById<TextView>(R.id.box21)
        val box22 = findViewById<TextView>(R.id.box22)
        val box23 = findViewById<TextView>(R.id.box23)
        val box24 = findViewById<TextView>(R.id.box24)
        val box25 = findViewById<TextView>(R.id.box25)

        val clickBox: List<View> =
            listOf(box1, box2, box3, box4, box5, box6, box7, box8, box9, box10,
                box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21,
                box22, box23, box24, box25)

        return clickBox
    }

    // Sets the visibility of the boxes and the retry button
    private fun setVisibility(){
        val clickBox: List<View> = makeArray()
        val retry_button = findViewById<Button>(R.id.retry)
        val scoreTitle = findViewById<TextView>(R.id.score_title)
        val count = findViewById<TextView>(R.id.textView)
        val name = findViewById<TextView>(R.id.textView4)

        for(item in clickBox){
            item.visibility = View.GONE
        }
        scoreTitle.visibility = View.GONE
        count.visibility = View.GONE
        retry_button.visibility = View.GONE
        name.visibility = View.GONE
    }

    private fun setListeners() {

        val clickBox: List<View> = makeArray()
        val retry_button = findViewById<Button>(R.id.retry)
        val scoreTitle = findViewById<TextView>(R.id.score_title)
        val count = findViewById<TextView>(R.id.textView)

        for (item in clickBox){
            item.visibility = View.VISIBLE
            item.setOnClickListener{ changeColor( it, mine, clickBox)
            countUp()}
        }
        setColor(clickBox, mine)
        retry_button.setOnClickListener{ retry( mine, clickBox ) }
        retry_button.visibility = View.VISIBLE
        scoreTitle.visibility = View.VISIBLE
        count.visibility = View.VISIBLE

    }

    // Makes the 2d array for the main function
    private fun makeMatrix(): Array<Array<Int>>{
        var arrayOfNumbers = arrayOf<Array<Int>>()

        for (i in 0..4) {
            var array = arrayOf<Int>()
            for (j in 0..4) {
                array += 0
            }
            arrayOfNumbers += array
        }
        return arrayOfNumbers
    }

    // For setting of the colors
    private fun setColor(view:List<View>, array: Array<Array<Int>>){
//        val editBox: TextView
        for(i in 0..4){
            for(j in 0..4){
                if(array[i][j] == 0)
                    view[(i*5)+j].setBackgroundColor(Color.BLACK)
                else
                    view[(i*5)+j].setBackgroundColor(Color.YELLOW)
            }
        }
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

    // Sets the numbers in the matrix
    private fun changeColor(view:View, array: Array<Array<Int>>, view2:List<View>){
        val tryy = checkIndex(view, view2)
        val row: Int = tryy[0]
        val col: Int = tryy[1]

        if(array[row][col] == 1) array[row][col] = 0
        else array[row][col] = 1

        if((row-1) != -1 && (row+1) != 5){
            if(array[row-1][col] == 1) array[row-1][col] = 0
            else array[row-1][col] = 1
            if (array[row+1][col] == 1) array[row+1][col] = 0
            else array[row+1][col] = 1
        } else if((row-1) == -1){
            if(array[row+1][col] == 1) array[row+1][col] = 0
            else array[row+1][col] = 1
        } else{
            if(array[row-1][col] == 1) array[row-1][col] = 0
            else array[row-1][col] = 1
        }

        if((col-1) != -1 && (col+1) != 5){
            if(array[row][col-1] == 1) array[row][col-1] = 0
            else array[row][col-1] = 1
            if(array[row][col+1] == 1) array[row][col+1] = 0
            else array[row][col+1] = 1
        } else if((col-1) == -1){
            if(array[row][col+1] == 1) array[row][col+1] = 0
            else array[row][col+1] = 1
        } else{
            if(array[row][col-1] == 1) array[row][col-1] = 0
            else array[row][col-1] = 1
        }

        setColor(view2, array)
    }

    // For function of the retry button
    private fun retry(array: Array<Array<Int>>, view2:List<View>){
        val click: TextView = findViewById(R.id.textView)
        for(i in 0..4){
            for(j in 0..4){
                array[i][j] = 0
            }
        }
        setColor(view2, array)
        numOfClicks = 0
        click.text = numOfClicks.toString()
    }

    // For checking of number of clicks
     fun countUp(){
        val click: TextView = findViewById(R.id.textView)
         numOfClicks++
         click.text = numOfClicks.toString()
    }



}

