package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class ActivityProfile: AppCompatActivity() {

    private lateinit var berandaImageView: ImageView
    private lateinit var absenImageView: ImageView

    private fun initComponents(){
        berandaImageView=findViewById(R.id.imageView)
        absenImageView = findViewById(R.id.imageView2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initComponents()

        berandaImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeKiri_Finish(this,intent)
        }

        absenImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenQR::class.java)
            TransisiActivity.transisiKeAtas_Finish(this,intent)
        }
    }

    override fun onBackPressed() {
        berandaImageView.performClick()
    }

}