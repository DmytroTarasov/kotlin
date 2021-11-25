package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditActivity : AppCompatActivity() {
    var imageLayout: ConstraintLayout ?= null
    var fbAddImage: FloatingActionButton ?= null
    val imageRequestCode = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        imageLayout = findViewById(R.id.mainConstraintLayout)
        fbAddImage = findViewById(R.id.fbAddImage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun onClickAddImage(view: View) {
        imageLayout?.visibility = View.VISIBLE
        fbAddImage?.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {
        imageLayout?.visibility = View.GONE
        fbAddImage?.visibility = View.VISIBLE
    }

    fun onClickChooseImage(view: View) {
        val i = Intent(Intent.ACTION_PICK)
        i.type = "image/*"
        startActivityForResult(i, imageRequestCode)
    }
}