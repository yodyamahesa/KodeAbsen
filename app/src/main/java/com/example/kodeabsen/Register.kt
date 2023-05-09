package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Register: AppCompatActivity() {

    lateinit var usernameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmpasswordEditText: EditText
    lateinit var daftarButton: Button

    fun initComponnents(){
        usernameEditText = findViewById(R.id.username_Register_EditText)
        emailEditText = findViewById(R.id.email_Register_EditText)
        passwordEditText = findViewById(R.id.password_Register_EditText)
        confirmpasswordEditText = findViewById(R.id.confirmpassword_Register_EditText)
        daftarButton = findViewById(R.id.daftar_Register_Button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        initComponnents()

        daftarButton.setOnClickListener{
            val keRegisterDone = Intent(this, RegisterDone::class.java)
            finish()
            startActivity(keRegisterDone)
        }
    }
}