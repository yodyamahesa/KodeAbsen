package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityGabungKelas4 :AppCompatActivity{
    private lateinit var okeButton: Button

    private fun initComponents(){
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_2)
        initComponents()

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityGabungKelas4::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }
}