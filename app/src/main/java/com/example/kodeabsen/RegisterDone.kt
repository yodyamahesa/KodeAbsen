package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterDone: AppCompatActivity() {

    lateinit var okeButton: Button

    fun initComponents(){
        okeButton = findViewById(R.id.oke_RegisterDone_Button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_done)

        initComponents()

        okeButton.setOnClickListener{
            val keLogin = Intent(this, Login::class.java)
            finish()
            startActivity(keLogin)
        }
    }
}