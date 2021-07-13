package com.example.uidemoapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //lateinit var pDlg : ProgressDialog
    lateinit var pBar : ProgressBar
    lateinit var parent : ConstraintLayout
    lateinit var snackbar: Snackbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pBar = findViewById(R.id.progressBar)
        parent = findViewById(R.id.cLayout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Start")
        menu?.add("Stop")
        menu?.add("Exit")
        menu?.add("Settings")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Start" -> {
                //starting task
                //show progress dialog
               // pDlg = ProgressDialog.show(this, "Downloading", "Please Wait")
                pBar.visibility = View.VISIBLE
                //pBar.progress = 50
                val t = Toast.makeText(this, "Task Started", Toast.LENGTH_LONG)
                t.setGravity(Gravity.TOP, 20, 100)
                t.show()

                snackbar = Snackbar.make(parent, "This is snackbar" , Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("Cancel", View.OnClickListener {
                    Toast.makeText(this, "Cancelling", Toast.LENGTH_LONG).show()
                })
                snackbar.show()

            }
            "Stop" -> {
                //pDlg.cancel()
                pBar.visibility = View.INVISIBLE
                snackbar.dismiss()

            }
            "Settings" -> {
                val dlg = MyDialog()
                val b = Bundle()
                b.putInt("type", 2)
                dlg.arguments = b
                dlg.show(supportFragmentManager,"")
            }
            "Exit" -> {
                val dlg = MyDialog()
                val myBundle = Bundle()

                myBundle.putString("msg", "Do you want to exit")
                myBundle.putString("title", "Confirmation")
                myBundle.putInt("type", 1)

                dlg.arguments = myBundle

                dlg.isCancelable = false
                dlg.show(supportFragmentManager, "xyz")
               // finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val dlg = MyDialog()
        val myBundle = Bundle()
        myBundle.putString("msg", "Are you sure about exiting")
        myBundle.putString("title", "Quit")

        dlg.arguments = myBundle
        dlg.show(supportFragmentManager, "xyz")

    }

    fun fabOnClicked(view: View) {
        Toast.makeText(this, "FAB onclicked", Toast.LENGTH_LONG).show()
        val i = Intent(this, DateTimeActivity::class.java)
        startActivity(i)
    }

    fun buttonClick(view: View) {
        val btn = view as Button
        Toast.makeText(this, "${btn.text} clicked", Toast.LENGTH_LONG).show()
        lateinit var intent : Intent
        when(view.id){
            R.id.cbDemoB -> {
                intent = Intent(this, CheckboxDemoActivity::class.java)
            }
            R.id.rbDemoB -> {
                intent = Intent(this, RadioButtonActivity::class.java)
            }
            R.id.lvDemoB -> {
                intent = Intent(this, ListViewActivity::class.java)
            }
            R.id.spDemoB -> {
                intent = Intent(this, SpinnerDemoActivity::class.java)
            }
            R.id.customB -> {
                intent = Intent(this, CustomAdapterActivity::class.java)
            }
        }
        startActivity(intent)
    }

}