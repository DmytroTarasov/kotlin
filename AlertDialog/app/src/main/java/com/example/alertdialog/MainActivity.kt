package com.example.alertdialog

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //createSimpleDialog()

        createSimpleMultiChoiceDialog()
    }

    private fun createSimpleDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert dialog")
        builder.setMessage("This is alert dialog")

        // 3 types of buttons: neutral, negative and positive
        builder.setNeutralButton("Info") { dialogInterface, i ->
        }

        builder.setNegativeButton("No"){ dialogInterface, i ->
        }

        builder.setPositiveButton("Yes"){ dialogInterface, i ->
        }

        builder.show()
    }

    private fun createSimpleMultiChoiceDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Что вам больше нравится")
//        builder.setMessage("This is alert dialog")
        builder.setMultiChoiceItems(R.array.multi_item, null) {dialog, which, isChoice ->
            Log.d("MyLog", "My choice is : $which / $isChoice")
        }

        // 3 types of buttons: neutral, negative and positive
        builder.setNeutralButton("Info") { dialogInterface, i ->
        }

        builder.setNegativeButton("No"){ dialogInterface, i ->
        }

        builder.setPositiveButton("Yes"){ dialogInterface, i ->
        }

        builder.show()
    }



}