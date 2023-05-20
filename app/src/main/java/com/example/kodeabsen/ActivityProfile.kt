package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class ActivityProfile: AppCompatActivity() {

    private lateinit var berandaImageView: ImageView
    private fun initComponents(){
        berandaImageView=findViewById(R.id.imageView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initComponents()

        berandaImageView.setOnClickListener {
            val keActivityBeranda = Intent(this, ActivityBeranda::class.java)

                startActivity(keActivityBeranda)

        }
    }

}