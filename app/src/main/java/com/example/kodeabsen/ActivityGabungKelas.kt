package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ActivityGabungKelas :AppCompatActivity () {

    private lateinit var kodeGabungEditText: EditText
    private lateinit var okeButton: Button
    private lateinit var kembaliImageView: ImageView
    private lateinit var email: String
    private lateinit var emailku: String
    private lateinit var database: DatabaseReference
    private lateinit var kode: String


    private fun initComponents() {
        kodeGabungEditText = findViewById(R.id.editTextText)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        kembaliImageView = findViewById(R.id.imageView11)
        database = Firebase.database.reference

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_1)
        initComponents()

        val extras = intent.extras
        if (extras != null) {
            emailku = (extras.getString("email")).toString()
        }

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            intent.putExtra("email", email)
            TransisiActivity.transisiKeBawah_Finish(this, intent)
        }

            okeButton.setOnClickListener {
                kode = kodeGabungEditText.text.toString()
                database.child("kelas").child(kode).get().addOnSuccessListener {
                    val namakelas = it.child("namaKelas").value.toString()
                    val email = it.child("email").value.toString()
                    val kodemasuk = it.child("kodekelas").value.toString()
                    if(kode==kodemasuk){
                        val intent = Intent(this, ActivityGabungKelas2::class.java)
                        intent.putExtra("email",email)
                        intent.putExtra("namakelas",namakelas)
                        intent.putExtra("kode",kodemasuk)
                        intent.putExtra("emailku",emailku)
                        TransisiActivity.transisiKeKanan_Finish(this,intent)
                    }else{
//                    kodeTextView.setText(namakelas)
//                    val intent = Intent(this, ActivityBeranda::class.java)
//                    TransisiActivity.transisiKeKiri_Finish(this,intent)
                    }
                }.addOnFailureListener{

                }
        }
    }
}