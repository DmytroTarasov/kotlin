package com.example.semafor

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imgSemafor: ImageView? = null
    // create an array with images
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    var counter: Int = 0
    var timer: Timer? = null
    var isRun: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgSemafor = findViewById(R.id.imgSemafor)
//        imgSemafor?.setImageResource(imageArray[1])
    }

    fun onClickStartStop(view: View) { // view - all elements on the activity
        view as ImageButton // cast view to an ImageButton
        // when clicking on start button, creating a timer; when clicking on stop button, delete a timer
        // imgSemafor?.setImageResource(R.drawable.semafor_green)
        if (!isRun) {
            timer = Timer()
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        } else {
            imgSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel() // stopping a timer
            isRun = false
            counter = 0
        }
    }

    fun startStop() {
        timer?.schedule(object : TimerTask() { // object expression
            override fun run() {
                runOnUiThread() {
                    imgSemafor?.setImageResource(imageArray[counter])
                    counter++ // indicates which image to display (0, 1, 2)
                    if (counter == 3) {
                        counter = 0
                    }
                }
            }
        }, 0, 1000)
    }
}