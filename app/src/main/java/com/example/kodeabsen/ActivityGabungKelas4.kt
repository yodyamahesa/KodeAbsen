package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityGabungKelas4 :AppCompatActivity() {
    private lateinit var okeButton: Button
    private lateinit var email: String

    private fun initComponents() {
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_4)
        initComponents()

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
        }

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            intent.putExtra("email",email)
            TransisiActivity.transisiKeKanan_Finish(this, intent)
        }
    }
}