package com.example.lightsout

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lightsout.databinding.FragmentMainGameBinding

class mainGame : Fragment() {

    // Initialization of global variables
    private lateinit var binding: FragmentMainGameBinding
    private lateinit var view3: View
    private val scoreName: ScoreName = ScoreName()
    var matrix = makeMatrix()
    var numOfClicks: Int = scoreName.score.toInt()
    var numOfLights: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentMainGameBinding>(inflater,
            R.layout.fragment_main_game,container,false)

        setListeners()
        return binding.root
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

    // Sets the listeners of each item
    private fun setListeners() {

        binding.apply{
        val clickBox: List<View> =
            listOf(box1, box2, box3, box4, box5, box6, box7, box8, box9, box10,
                box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21,
                box22, box23, box24, box25)
        for (item in clickBox){
                item.setOnClickListener{ changeColor( it, matrix, clickBox)
                    countUp()}
            }
            setColor(clickBox, matrix)
            retry.setOnClickListener{ retry( matrix, clickBox ) }
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
    private fun setColor(view2:List<View>, array: Array<Array<Int>>){
        // Loop for setting the color of items
        for(i in 0..4){
            for(j in 0..4){
                if(array[i][j] == 0)
                    view2[(i*5)+j].setBackgroundColor(Color.BLACK)
                else
                    view2[(i*5)+j].setBackgroundColor(Color.YELLOW)
            }
        }
        if(checkStage()) {
            scoreName.score = numOfClicks.toString()
            view?.findNavController()?.navigate(R.id.action_mainGame_to_gameFinish)
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

        for(i in 0..4) for(j in 0..4)array[i][j] = 1
        setColor(view2, array)
        for(item in view2) item.visibility = View.VISIBLE
        numOfClicks = 0
        numOfLights = 0
        binding.textView.text = numOfClicks.toString()
    }

    // For checking of number of clicks
    fun countUp(){

        numOfClicks++
        binding.textView.text = numOfClicks.toString()
    }
}
