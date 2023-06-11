package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityAbsenKode: AppCompatActivity() {

    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenQRImageView: ImageView
    private lateinit var tombolLanjutkanButton: Button

    fun initComponents(){
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenQRImageView = findViewById(R.id.imageView19)
        tombolLanjutkanButton = findViewById(R.id.oke_RegisterDone_Button3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_kode)

        initComponents()

        tombolKembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)
        }

        tombolAbsenQRImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenQR::class.java)
            TransisiActivity.transisiKeKiri_Finish(this,intent)
        }

        tombolLanjutkanButton.setOnClickListener{

        }

    }

    override fun onBackPressed() {
        tombolKembaliImageView.performClick()
    }

}