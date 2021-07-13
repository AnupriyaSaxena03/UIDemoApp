package com.example.uidemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_checkbox_demo.*

class CheckboxDemoActivity : AppCompatActivity() {
    val cityList  = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_demo)
    }

    fun cbClicked(view: View) {
        val cBox = view as CheckBox
        var cityName = cBox.text.toString()
        when(cBox.id){
            R.id.blrB -> cityName = "BLR"
            R.id.puneB -> cityName = "PNE"
            R.id.dlhB -> cityName = "DLH"
            R.id.hydB -> cityName = "HYD"


        }
        if(cBox.isChecked){
            Toast.makeText(this, "$cityName selected", Toast.LENGTH_LONG).show()
            
            cityList.add(cityName)
        }
        else{
            Toast.makeText(this, "$cityName unchecked", Toast.LENGTH_LONG).show()
            cityList.remove(cityName)
        }
        locationsT.text = "$cityList"

    }


}