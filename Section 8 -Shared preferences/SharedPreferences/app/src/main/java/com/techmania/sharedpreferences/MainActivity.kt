package com.techmania.sharedpreferences

import android.content.Context
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

    var name:String? = null
    var message:String? = null
    var isChecked:Boolean? = null

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.editTextName)
        userMessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

        counter.setOnClickListener {

            count ++
            counter.setText("" + count)

        }

    }

    override fun onPause() {
        super.onPause()

        saveData()

    }

    fun saveData()
    {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = remember.isChecked

        val editor = sharedPreferences.edit()

        editor.putString("key name",name)
        editor.putString("key message",message)
        editor.putInt("key count",count)
        editor.putBoolean("key remember",isChecked!!)

        editor.apply()

        Toast.makeText(applicationContext,"Your data is saved.",Toast.LENGTH_LONG).show()
    }

    fun retreiveData()
    {

        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        name = sharedPreferences.getString("key name",null)
        message = sharedPreferences.getString("key message",null)
        count = sharedPreferences.getInt("key count",0)
        isChecked = sharedPreferences.getBoolean("key remember",false)

        userName.setText(name)
        userMessage.setText(message)
        counter.setText("" + count)
        remember.isChecked = isChecked!!

    }

    override fun onResume() {
        super.onResume()
        
        retreiveData()

    }

}