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
    private lateinit var emailku: String
    fun initcomponents(){
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buatkelas_3)

        initcomponents()

        val extras = intent.extras
        if (extras != null) {
            emailku = (extras.getString("email")).toString()
        }

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            intent.putExtra("email",emailku)
            TransisiActivity.transisiKeBawah_Finish(this,intent)
        }
    }
}