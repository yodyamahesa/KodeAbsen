package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityBuatKelas3: AppCompatActivity() {

    private lateinit var okeButton: Button
    fun initcomponents(){
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buatkelas_3)

        initcomponents()

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)
        }
    }
}