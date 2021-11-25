package com.example.savedata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private var counter1 = "0"
    private var tvResult: TextView?= null
    private var tvResult2: TextView?= null
    private var pref: SharedPreferences ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
        tvResult2 = findViewById(R.id.tvResult2)

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE) // create a preference
        counter = pref?.getInt("counter", 0)!!
        counter1 = pref?.getString("counter1", "0")!!
        tvResult?.text = counter.toString()
        tvResult2?.text = counter1

    }

    fun onClickAdd(view: View) { // слушатель нажатий
        counter++
        tvResult?.text = counter.toString()
        saveData(counter)
    }

    private fun saveData(res: Int) {
        val editor = pref?.edit() // open a preference for a modification
        editor?.putInt("counter", res)
        editor?.putString("counter1", "Test")
        editor?.apply()
    }

    private fun deleteAll() {
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply() // save a modification
    }

    private fun deleteItem(deleteItem: String) {
        val editor = pref?.edit()
        editor?.remove(deleteItem)
        editor?.apply() // save a modification
    }

    fun onClickClear(view: View) {
        deleteAll()
    }

    fun onClickDeleteItem(view: View) {
        deleteItem("counter")
    }
}