package com.example.kodeabsen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityHome: AppCompatActivity() {

    lateinit var emailTextView: TextView

    fun initComponents(){
        emailTextView = findViewById(R.id.nama_Home_TextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initComponents()
        val email = intent.getStringExtra("email")
        emailTextView.setText(email)
    }
}