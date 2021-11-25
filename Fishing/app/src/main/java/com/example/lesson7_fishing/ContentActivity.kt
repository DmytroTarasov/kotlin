package com.example.lesson7_fishing

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    var tvTitle: TextView ?= null
    var tvContent: TextView ?= null
    var image: ImageView ?= null
    var webView: WebView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_2_layout)
        tvTitle = findViewById(R.id.tvTitleFull)
        tvContent = findViewById(R.id.tvDescrFull)
        image = findViewById(R.id.imageFull)

        webView = findViewById(R.id.webView)

        webView?.loadUrl("file:///android_asset/item1.html")

//        tvTitle?.text = intent.getStringExtra("title")
//        tvContent?.text =  intent.getStringExtra("content")
//        image?.setImageResource(intent.getIntExtra("image", R.drawable.som))


    }
}