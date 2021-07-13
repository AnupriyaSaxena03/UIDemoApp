package com.example.uidemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinner_demo.*

class SpinnerDemoActivity : AppCompatActivity(),  AdapterView.OnItemSelectedListener {
    val langList = mutableListOf("Kotlin", "Java", "Swift", "Dart")

    lateinit var adapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_demo)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, langList)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val lang = langList[position]
        Toast.makeText(this, "Selection: $lang", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Please select", Toast.LENGTH_LONG).show()
    }


}