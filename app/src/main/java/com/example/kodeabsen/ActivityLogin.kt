package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityLogin: AppCompatActivity() {

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var masukButton: Button
    lateinit var daftarTextView: TextView
    private lateinit var auth: FirebaseAuth

    fun initComponents(){
        emailEditText = findViewById(R.id.email_Login_EditText)
        passwordEditText = findViewById(R.id.password_Login_EditText)
        masukButton = findViewById(R.id.masuk_Login_Button)
        daftarTextView = findViewById(R.id.daftar_Login_TextView)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        initComponents()

        daftarTextView.setOnClickListener {
            val keActivityRegister = Intent(this, ActivityRegister::class.java)
            startActivity(keActivityRegister)
        }

        masukButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val keActivityHome = Intent(this, ActivityBeranda::class.java)
                            finish()
                            keActivityHome.putExtra("email","Email: $email")
                            startActivity(keActivityHome)
                        } else {
                            Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(this, "Silahkan melengkapi formulir", Toast.LENGTH_SHORT).show()
            }
        }
    }
}