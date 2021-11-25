package com.example.compass

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {

    var manager: SensorManager ?= null // we use this manager to register a sensor event listener
    var current_degree: Int = 0
    var tvDegree: TextView ?= null
    var imDynamic: ImageView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        tvDegree = findViewById(R.id.tvDegree)
        imDynamic = findViewById(R.id.imDynamic)
    }

    override fun onResume() {
        super.onResume()
        manager?.registerListener(this, manager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_GAME) // register a listener
    }

    override fun onPause() {
        super.onPause()
        manager?.unregisterListener(this) // unregister a listener
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val degree: Int = event?.values?.get(0)?.toInt()!!
        tvDegree?.text = degree.toString()
        val rotationAnim = RotateAnimation(current_degree.toFloat(), (-degree).toFloat(), Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        // the first argument is a degree "from", second argument - degree "to", and then we
        // specify the point, relatively to which (относительно которой) we will rotate an imageview
        rotationAnim.duration = 210 // duration - 210ms
        rotationAnim.fillAfter = true
        current_degree = -degree // degree "from"

        imDynamic?.startAnimation(rotationAnim) // start an animation
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}