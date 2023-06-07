package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityAbsenQR: AppCompatActivity() {

    private lateinit var tombolFlashImageView: ImageView
    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenKodeImageView: ImageView
    private var flash = 0;

    fun initComponents(){
        tombolFlashImageView = findViewById(R.id.flash)
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenKodeImageView = findViewById(R.id.imageView20)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_qr)

        initComponents()

        tombolFlashImageView.setOnClickListener{
            if(flash==0){
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_on)
                flash=1
            }else{
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_off)
                flash=0
            }

        }

        tombolKembaliImageView.setOnClickListener {
            val keActivityBeranda = Intent(this, ActivityBeranda::class.java)
            startActivity(keActivityBeranda)
            finish()
        }

        tombolAbsenKodeImageView.setOnClickListener {
            val keActivityAbsenKode = Intent(this, ActivityAbsenKode::class.java)
            startActivity(keActivityAbsenKode)
            finish()
        }


    }
}