package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.sqlite.db.MyDbManager

class MainActivity : AppCompatActivity() {
    var title: EditText ?= null
    var content: EditText ?= null
    var tvText: TextView?= null
    var myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        title = findViewById(R.id.idTitle)
//        content = findViewById(R.id.idContent)
//        tvText = findViewById(R.id.tvText)
    }

    fun onClickNew(view: View) {
//        tvText?.text = ""
//        myDbManager.openDb()
//        myDbManager.insertToDb(title?.text.toString(), content?.text.toString())
//        val dataList = myDbManager.readDbData()
//        for (item in dataList) {
//            tvText?.append(item)
//            tvText?.append("\n")
//        }
        var i = Intent(this, EditActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }
}