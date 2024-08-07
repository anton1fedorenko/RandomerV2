package com.example.randomer

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaration of values by setting them a value of displayed palette
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val quantity = findViewById<EditText>(R.id.quantity)
        val rangeMin = findViewById<EditText>(R.id.rangeMin)
        val rangeMax = findViewById<EditText>(R.id.rangeMax)
        val rollButton = findViewById<Button>(R.id.rollButton)

        resultsTextView.movementMethod = ScrollingMovementMethod() //adding scroll movement to a TextView

        //adding displayable hints for the EditText palettes
        quantity.setHint("1")
        rangeMin.setHint("1")
        rangeMax.setHint("10")

        //actions when "Roll" button is pressed
        rollButton.setOnClickListener {
            resultsTextView.text = "" //clearing a TextView after every time the button is pressed

            //checking if EditView is not empty. displaying error message with Toast
            if (quantity.text.toString().isNullOrEmpty() || rangeMin.text.toString().isNullOrEmpty() || rangeMax.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var quantityList : ArrayList<String> = arrayListOf() //list for random generated numbers
            //converting EditView for Editable to Int
            var min : Int = rangeMin.text.toString().toInt()
            var max : Int = rangeMax.text.toString().toInt()
            var quantity : Int = quantity.text.toString().toInt()

            //checking if range is not inverted
            if (min > max){
                Toast.makeText(this, "Range set wrong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //generating "quantity" of random numbers in a range from "rangeMin" to "rangeMax" + adding them to the list
             for (i in 0..quantity){
                var rand = (min..max).random()
                quantityList.add(rand.toString())
            }

            //displaying list in TextView
            for(i in 0 until quantity){
                if (i == quantity - 1){
                    resultsTextView.append(quantityList[i])
                }else{
                    resultsTextView.append("${quantityList[i]} ")
                }
            }



        }
    }
}