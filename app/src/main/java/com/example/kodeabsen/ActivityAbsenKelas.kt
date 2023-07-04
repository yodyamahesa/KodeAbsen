package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ActivityAbsenKelas:AppCompatActivity() {

    private lateinit var email: String
    private lateinit var namakelas: String
    private lateinit var kode: String
    private lateinit var namakelasEditText: EditText
    private lateinit var emailKelasEditText: EditText
    private lateinit var okeButton: Button

    fun initComponents() {
        namakelasEditText = findViewById(R.id.editText)
        emailKelasEditText = findViewById(R.id.editTextText2)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_kelas)

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
            namakelas = (extras.getString("namakelas")).toString()
            kode = (extras.getString("kodekelas")).toString()
        }

        initComponents()
        namakelasEditText.setText(namakelas)
        emailKelasEditText.setText(email)

        okeButton.setOnClickListener {
            val intent = Intent(this, ActivityAbsenKelas2::class.java)
            TransisiActivity.transisiKeBawah_Finish(this, intent)



        }

    }
}