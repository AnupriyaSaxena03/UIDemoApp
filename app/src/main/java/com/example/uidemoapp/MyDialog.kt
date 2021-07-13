package com.example.uidemoapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       lateinit var myDlg : Dialog
       val parent = activity
        val args = arguments
        val message = args?.getString("msg")
        val title = args?.getString("title")
        val dlgType = args?.getInt("type")
        //create dialog

        val builder = AlertDialog.Builder(parent)

        when(dlgType) {
            1 -> {


                builder.setTitle(title)
                builder.setMessage(message)

                builder.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                    parent?.finish()
                })

                builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()

                })
                myDlg = builder.create()
            }
            2 -> {
                //custom dialog
                builder.setView(R.layout.custom_dlg)
                myDlg = builder.create()
            }
            3 -> {
                //date picker
                val calender = Calendar.getInstance()
                val year = calender.get(Calendar.YEAR)
                val month = calender.get(Calendar.MONTH)
                val day = calender.get(Calendar.DAY_OF_MONTH)

                myDlg = DatePickerDialog(parent!!, parent as DatePickerDialog.OnDateSetListener, year, month, day)
            }
            4 -> {
                //time picker
                myDlg = TimePickerDialog(parent, parent as TimePickerDialog.OnTimeSetListener, 6, 0 , false)
            }
        }



        return myDlg
    }
}