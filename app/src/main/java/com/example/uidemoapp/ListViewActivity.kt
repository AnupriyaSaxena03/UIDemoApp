package com.example.uidemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    val langList = mutableListOf("Kotlin", "Java", "Swift", "Dart")
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        //Adapter - supply data
        //Array Adapter - if data is a part of collection
        //Cursor Adaptor - if data is a part of a cursor as a result of query
        //list view, spinner,GridView, RecyclerView - Adapters

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, langList)
        lv.adapter = adapter
        lv.onItemClickListener = this
        registerForContextMenu(lv)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val lang = langList[position]
        Toast.makeText(this,"Selection: $lang", Toast.LENGTH_LONG).show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val lang = langList[info.position]

        menu?.add(0,1,0,"Delete $lang")
        menu?.add("View")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when(item.itemId){
            1 -> {
                langList.removeAt(info.position)
                Toast.makeText(this, "Removed from list at index ${info.position}",Toast.LENGTH_LONG).show()
                //call this method whenever data is changed,listview is refreshed
                adapter.notifyDataSetChanged()
            }
            2 -> {}
        }
        return super.onContextItemSelected(item)
    }
}