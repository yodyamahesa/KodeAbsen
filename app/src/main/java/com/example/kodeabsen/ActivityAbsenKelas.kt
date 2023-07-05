package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ActivityAbsenKelas:AppCompatActivity() {

    private lateinit var email: String
    private lateinit var emailku: String
    private lateinit var namakelas: String
    private lateinit var kode: String
    private lateinit var namakelasEditText: EditText
    private lateinit var emailKelasEditText: EditText
    private lateinit var okeButton: Button
    private lateinit var database: DatabaseReference


    fun initComponents() {
        namakelasEditText = findViewById(R.id.editText)
        emailKelasEditText = findViewById(R.id.editTextText2)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        database = Firebase.database.reference

    }

    fun writeAbsenKelas(email: String) {
        val join = AbsenKelas.absen(email)
        database.child("absen").child(kode).setValue(join)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_kelas)

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
            emailku = (extras.getString("emailku")).toString()
            namakelas = (extras.getString("namakelas")).toString()
            kode = (extras.getString("kode")).toString()
        }

        initComponents()
        namakelasEditText.setText(namakelas)
        emailKelasEditText.setText(email)

        okeButton.setOnClickListener {
            writeAbsenKelas(emailku)
            val intent = Intent(this, ActivityAbsenKelas2::class.java)
            intent.putExtra("email",email)
            TransisiActivity.transisiKeBawah_Finish(this, intent)

        }

    }
}