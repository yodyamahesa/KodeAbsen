package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ActivityGabungKelas2 :AppCompatActivity(){
    private lateinit var matkulEditText: EditText
    private lateinit var dosenEditText: EditText
    private lateinit var okeButton: Button
    private lateinit var kembaliImageView: ImageView

    private fun initComponents(){
        matkulEditText = findViewById(R.id.editText)
        dosenEditText = findViewById(R.id.editTextText2)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        kembaliImageView = findViewById(R.id.imageView11)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_2)
        initComponents()

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityGabungKelas4::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
            }
}

