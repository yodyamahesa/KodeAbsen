package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ActivityBuatKelas1: AppCompatActivity() {

    private lateinit var masukkangambarImageView: ImageView
    private lateinit var namakelasTextView: TextView
    private lateinit var okeButton: Button
    private lateinit var kembaliImageView: ImageView
    private lateinit var database: DatabaseReference
    private lateinit var tes: String
    private lateinit var email: String
    private fun initComponents(){
        masukkangambarImageView = findViewById(R.id.imageView9)
        namakelasTextView = findViewById(R.id.editTextText)
        okeButton = findViewById(R.id.oke_RegisterDone_Button2)
        kembaliImageView = findViewById(R.id.imageView11)
        database = Firebase.database.reference
    }

    fun writeNewKelas(namaKelas: String, email: String) {
        val random = Random.randomkan()
        val kelas = NewKelas.Kelas(namaKelas, email, random)
        database.child("kelas").child(random).setValue(kelas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buatkelas_1)

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
        }

        initComponents()

        kembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)

        }

        okeButton.setOnClickListener {
            writeNewKelas(namakelasTextView.text.toString(),email)
            val intent = Intent(this, ActivityBuatKelas3::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
//            database.child("users").child("useridnya").get().addOnSuccessListener {
//                Log.i("firebase", "Got value ${it.value}")
//                tes = it.child("email").value.toString()
//                okeButton.setText(tes)
//            }.addOnFailureListener{
//                Log.e("firebase", "Error getting data", it)
//            }

        }


    }

}