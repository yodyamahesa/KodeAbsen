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
            val keActivityBeranda = Intent(this, ActivityBeranda::class.java)
            startActivity(keActivityBeranda)
            finish()
        }

        tombolAbsenQRImageView.setOnClickListener {
            val keActivityAbsenQR = Intent(this, ActivityAbsenQR::class.java)
            startActivity(keActivityAbsenQR)
            finish()
        }

        tombolLanjutkanButton.setOnClickListener{

        }


    }
}