package com.example.uidemoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi

class DateTimeActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
           TimePickerDialog.OnTimeSetListener
{
    lateinit var dateTextView : TextView
    lateinit var timeTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time)

        dateTextView = findViewById(R.id.dateT)
        timeTextView = findViewById(R.id.timeT)
    }

    fun dateClicked(view: View) {
        val dlg = MyDialog()
        val b = Bundle()
        b.putInt("type", 3)

        dlg.arguments = b
        dlg.show(supportFragmentManager, "")
    }
    fun timeClicked(view: View) {
        val dlg = MyDialog()
        val b = Bundle()
        b.putInt("type", 4)

        dlg.arguments = b
        dlg.show(supportFragmentManager, "")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val date = "$dayOfMonth-${month+1}-$year"
        Toast.makeText(this, "Selected Date: $date" , Toast.LENGTH_LONG).show()
        dateTextView.text = date

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        var amPm = ""
        if(view?.hour!! > 12)
            amPm = "pm"
        else
            amPm = "am"

        val time = "$hourOfDay hrs $minute sec $amPm"
        Toast.makeText(this, "Time: $time", Toast.LENGTH_LONG).show()
        timeTextView.text = time
    }
}