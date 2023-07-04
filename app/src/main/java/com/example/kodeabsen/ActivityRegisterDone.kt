package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class   ActivityRegisterDone: AppCompatActivity() {

    private lateinit var okeButton: Button

    private fun initComponents(){
        okeButton = findViewById(R.id.oke_RegisterDone_Button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_done)

        initComponents()

        okeButton.setOnClickListener{
            val keActivityLogin = Intent(this, ActivityLogin::class.java)
            finish()
            startActivity(keActivityLogin)
        }
    }
}