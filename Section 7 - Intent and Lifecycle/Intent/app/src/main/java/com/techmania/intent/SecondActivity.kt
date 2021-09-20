package com.techmania.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        result = findViewById(R.id.textView)

        var userName : String = intent.getStringExtra("username").toString()
        var userAge : Int = intent.getIntExtra("userage",0)

        result.text = "Your name is $userName and your age is $userAge"

    }
}