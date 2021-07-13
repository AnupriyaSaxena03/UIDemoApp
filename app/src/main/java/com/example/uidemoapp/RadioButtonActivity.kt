package com.example.uidemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        when(cityRG.checkedRadioButtonId){
            R.id.bomR -> cityT.text = "Mumbai"
            R.id.hydR -> cityT.text = "Hyderabad"
            R.id.chennaiR -> cityT.text = "Chennai"
            R.id.blrR -> cityT.text = "Bangalore"
            else -> cityT.text = "Select a city"
        }
    }

    fun rbClicked(view: View) {
        val rButton = view as RadioButton
        var cityName = rButton.text.toString()
        Toast.makeText(this, "City Selected: $cityName", Toast.LENGTH_LONG).show()
        cityT.text = cityName
    }
}