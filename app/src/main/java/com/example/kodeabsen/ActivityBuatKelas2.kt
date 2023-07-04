package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ActivityBuatKelas2: AppCompatActivity() {

    private lateinit var editTextText: TextView
    private lateinit var oke_RegisterDone_Button2: Button
    private lateinit var imageView11: ImageView

    fun initcomponents(){
        editTextText = findViewById(R.id.editTextText)
        oke_RegisterDone_Button2 = findViewById(R.id. oke_RegisterDone_Button2)
        imageView11 = findViewById(R.id.imageView11)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buatkelas_2)

        initcomponents()

        oke_RegisterDone_Button2.setOnClickListener {
            val intent = Intent(this, ActivityBuatKelas3::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }
    }
}