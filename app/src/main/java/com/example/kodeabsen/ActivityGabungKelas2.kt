package com.example.kodeabsen

import JoinKelas
import JoinPengguna
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ActivityGabungKelas2 :AppCompatActivity() {
    private lateinit var matkulEditText: EditText
    private lateinit var dosenEditText: EditText
    private lateinit var okeButton: Button
    private lateinit var kembaliImageView: ImageView
    private lateinit var email: String
    private lateinit var emailku: String
    private lateinit var namakelas: String
    private lateinit var kode: String
    private lateinit var database: DatabaseReference


    private fun initComponents() {
        matkulEditText = findViewById(R.id.editText)
        dosenEditText = findViewById(R.id.editTextText2)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        kembaliImageView = findViewById(R.id.imageView11)
        database = Firebase.database.reference

    }

    fun writeJoinKelas(email: String) {
        val join = JoinKelas.join(emailku)
        database.child("kelas").child(kode).child("pengguna").child(emailku.replace(".",",")).setValue(join)
    }

    fun writeJoinPengguna(kode: String) {
        val join = JoinPengguna.join(kode)
        database.child("pengguna").child(kode).child("pengguna").child(email.replace(".",",")).setValue(email)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gabungkelas_2)
        initComponents()

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
            emailku = (extras.getString("emailku")).toString()
            namakelas = (extras.getString("namakelas")).toString()
            kode = (extras.getString("kode")).toString()
        }

        matkulEditText.setText(namakelas)
        dosenEditText.setText(email)

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            intent.putExtra("email",emailku)
            TransisiActivity.transisiKeBawah_Finish(this, intent)
        }

        okeButton.setOnClickListener {
            writeJoinKelas(emailku)
            val intent = Intent(this, ActivityGabungKelas4::class.java)
            intent.putExtra("email",emailku)
            TransisiActivity.transisiKeKanan_Finish(this, intent)
        }
    }
}

