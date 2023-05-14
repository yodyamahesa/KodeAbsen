package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ActivityRegister: AppCompatActivity() {

    private lateinit var usernameRegisterEditText: EditText
    private lateinit var emailRegisterEditText: EditText
    private lateinit var passwordRegisterEditText: EditText
    private lateinit var confirmpasswordRegisterEditText: EditText
    private lateinit var daftarButton: Button
    private lateinit var auth: FirebaseAuth

    private fun initComponnents(){
        usernameRegisterEditText = findViewById(R.id.username_Register_EditText)
        emailRegisterEditText = findViewById(R.id.email_Register_EditText)
        passwordRegisterEditText = findViewById(R.id.password_Register_EditText)
        confirmpasswordRegisterEditText = findViewById(R.id.confirmpassword_Register_EditText)
        daftarButton = findViewById(R.id.daftar_Register_Button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        initComponnents()

        daftarButton.setOnClickListener{
            val username = usernameRegisterEditText.text.toString()
            val password = passwordRegisterEditText.text.toString()
            val confirmpassword = confirmpasswordRegisterEditText.text.toString()
            val email = emailRegisterEditText.text.toString()

            if(username.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty() && email.isNotEmpty()){
                if (password == confirmpassword){
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val keActivityRegisterDone = Intent(this, ActivityRegisterDone::class.java)
                                finish()
                                startActivity(keActivityRegisterDone)
                            }else {
                                Toast.makeText(this,"Registrasi Gagal",Toast.LENGTH_SHORT).show()
                            }
                        }
                }else{
                    Toast.makeText(this,"Password tidak sama",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Silahkan melengkapi formulir",Toast.LENGTH_SHORT).show()
            }
        }
    }
}