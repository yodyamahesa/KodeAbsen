package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login: AppCompatActivity() {

    lateinit var usernameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var masukButton: Button
    lateinit var daftarTextView: TextView

    fun initComponents(){
        usernameEditText = findViewById(R.id.username_Login_EditText)
        passwordEditText = findViewById(R.id.password_Login_EditText)
        masukButton = findViewById(R.id.masuk_Login_Button)
        daftarTextView = findViewById(R.id.daftar_Login_TextView)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        initComponents()

        masukButton.setOnClickListener{

        }

        daftarTextView.setOnClickListener{
            val keRegister = Intent(this,Register::class.java)
            startActivity(keRegister)
        }
    }


}