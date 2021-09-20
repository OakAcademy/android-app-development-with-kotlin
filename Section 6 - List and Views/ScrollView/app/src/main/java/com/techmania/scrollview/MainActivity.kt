package com.techmania.scrollview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var userMessage : EditText
    lateinit var counter : Button
    lateinit var remember : CheckBox

    var count : Int = 0
    var name : String? = null
    var message : String? = null
    var isChecked : Boolean? = null

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.editTextName)
        userMessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.buttonCounter)
        remember = findViewById(R.id.checkBox)

        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        count = sharedPreferences.getInt("count",0)
        counter.setOnClickListener {

            count++
            counter.setText("" + count)

        }

    }

    override fun onPause() {
        super.onPause()

        saveData()
    }

    fun saveData()
    {


        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = remember.isChecked
        
        val editor = sharedPreferences.edit()

        editor.putString("name",name)
        editor.putString("message",message)
        editor.putInt("count",count)
        editor.putBoolean("remember",isChecked!!)

        editor.apply()



        Toast.makeText(applicationContext,"Your data is saved",Toast.LENGTH_LONG).show()
    }

    fun retrieveData()
    {

        var newName = sharedPreferences.getString("name",null)
        var newMessage = sharedPreferences.getString("message",null)
        var newCount = sharedPreferences.getInt("count",0)
        var newIsChecked = sharedPreferences.getBoolean("remember",false)

        userName.setText(newName)
        userMessage.setText(newMessage)
        counter.setText(""+newCount)
        remember.isChecked = newIsChecked

    }

    override fun onResume() {
        super.onResume()

        retrieveData()
    }

}