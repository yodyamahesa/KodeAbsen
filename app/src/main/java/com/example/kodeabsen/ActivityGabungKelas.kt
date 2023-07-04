package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ActivityGabungKelas :AppCompatActivity () {

    private lateinit var kodeGabungEditText: EditText
    private lateinit var okeButton: Button
    private lateinit var kembaliImageView: ImageView

    private fun initComponents() {
        kodeGabungEditText = findViewById(R.id.editTextText)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        kembaliImageView = findViewById(R.id.imageView11)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_1)
        initComponents()

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this, intent)

            okeButton.setOnClickListener {
                val intent = Intent(this, ActivityGabungKelas2::class.java)
                TransisiActivity.transisiKeKanan_Finish(this, intent)
            }
        }
    }
}