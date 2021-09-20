package com.techmania.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    var countryNameList = ArrayList<String>()
    var detailsList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    lateinit var adapter : CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        countryNameList.add("United Kingdom")
        countryNameList.add("Germany")
        countryNameList.add("USA")

        detailsList.add("This is the United Kingdom Flag")
        detailsList.add("This is the Germany Flag")
        detailsList.add("This is the USA Flag")

        imageList.add(R.drawable.unitedkingdom)
        imageList.add(R.drawable.germany)
        imageList.add(R.drawable.usa)

        adapter = CountriesAdapter(countryNameList,detailsList,imageList,this@MainActivity)

        recyclerView.adapter = adapter


    }
}