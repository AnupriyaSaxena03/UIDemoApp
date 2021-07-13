package com.example.uidemoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_custom_adapter.*

class CustomAdapterActivity : AppCompatActivity() {
    val studentList = mutableListOf<Student>()
    lateinit var stdAdapter : StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter)
        studentList.add(Student("John", 1, 90.0))
        studentList.add(Student("Merry Rose", 2, 45.0))
        studentList.add(Student("Jerry", 3, 78.34))
        studentList.add(Student("Mike Tyson", 4, 82.4))
        studentList.add(Student("Robert", 5, 99.0))
        stdAdapter = StudentAdapter(this, R.layout.student_list_item, studentList)

        studentL.adapter = stdAdapter
    }
}
data class Student(val name : String, val id: Int, var marks: Double)

class StudentAdapter(context: Context, layoutId: Int, data: List<Student>  ):
    ArrayAdapter<Student>(context, layoutId, data){
    //called for each item in the collection
    //return the view
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.d("StudentAdapter", "getView called for position: $position")

       // return super.getView(position, convertView, parent)
        //render the view/layout - only if it was not created earlier
        lateinit var view: View
        if(convertView == null)

         view = LayoutInflater.from(context).inflate(R.layout.student_list_item, null)
        else
            view = convertView
        //data binding
        val std = getItem(position)
        val nameTextView = view.findViewById<TextView>(R.id.nameT)
        val idTextView = view.findViewById<TextView>(R.id.idT)
        val marksTV = view.findViewById<TextView>(R.id.marksT)

        nameTextView.text = std?.name
        idTextView.text = "${std?.id}"
        marksTV.text = "${std?.marks}"

        return view

    }
    }
