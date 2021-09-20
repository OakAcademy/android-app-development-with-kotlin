package com.techmania.radiobuttons

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    lateinit var linearLayout : LinearLayout
    lateinit var green : RadioButton
    lateinit var yellow : RadioButton
    lateinit var red : RadioButton
    lateinit var change : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linearLayout)
        green = findViewById(R.id.radioButtonGreen)
        yellow = findViewById(R.id.radioButtonYellow)
        red = findViewById(R.id.radioButtonRed)
        change = findViewById(R.id.buttonChange)

        change.setOnClickListener {

            if (green.isChecked)
            {
                linearLayout.setBackgroundColor(Color.GREEN)
            }
            else if (yellow.isChecked)
            {
                linearLayout.setBackgroundColor(Color.YELLOW)
            }
            else if (red.isChecked)
            {
                linearLayout.setBackgroundColor(Color.RED)
            }

        }

    }
}