package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityEditProfil: AppCompatActivity() {
    private lateinit var kembaliImageView: ImageView
    fun initcomponent(){
        kembaliImageView=findViewById(R.id.imageView5)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_2)
        initcomponent()

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeKiri_Finish(this,intent)
        }

    }


}