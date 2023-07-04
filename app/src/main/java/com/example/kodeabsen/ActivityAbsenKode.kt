package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.zxing.client.android.BeepManager
import kotlin.math.log

class ActivityAbsenKode: AppCompatActivity() {

    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenQRImageView: ImageView
    private lateinit var tombolLanjutkanButton: Button
    private lateinit var kodeTextView: EditText
    private lateinit var database: DatabaseReference
    private lateinit var kode: String

    fun gatau(){
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d("tag", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("tag", "Failed to read value.", error.toException())
            }
        })
    }

    fun initComponents(){
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenQRImageView = findViewById(R.id.imageView19)
        tombolLanjutkanButton = findViewById(R.id.oke_RegisterDone_Button3)
        kodeTextView = findViewById(R.id.editTextText3)
        database = Firebase.database.reference
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_kode)

        initComponents()

        tombolKembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this, intent)
        }

        tombolAbsenQRImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenQR::class.java)
            TransisiActivity.transisiKeKiri_Finish(this, intent)
        }

        tombolLanjutkanButton.setOnClickListener {
            kode = kodeTextView.text.toString()
            database.child("kelas").child(kode).get().addOnSuccessListener {
                val namakelas = it.child("namaKelas").value.toString()
                val email = it.child("email").value.toString()
                val kodemasuk = it.child("kodekelas").value.toString()
                if(kode==kodemasuk){
                    val intent = Intent(this, ActivityAbsenKelas::class.java)
                    intent.putExtra("email",email)
                    intent.putExtra("namakelas",namakelas)
                    intent.putExtra("kode",kodemasuk)
                    TransisiActivity.transisiKeKanan_Finish(this,intent)
                }else{
//                    kodeTextView.setText(namakelas)
//                    val intent = Intent(this, ActivityBeranda::class.java)
//                    TransisiActivity.transisiKeKiri_Finish(this,intent)
                }
            }.addOnFailureListener{
                Log.i("ini yod nilainya","failure dia")
            }

//            kodeTextView.setText(namakelas)



//            readData()
//            gatau()
//            kodeTextView.setText(aa)

//            Log.i("ini yod nilainya setelah kelaur",namakelas)

//            Log.i("variabel",kode)
//            Log.i("variabelmasuk",kodemasuk)
//
//            if(kode==kodemasuk){
//                val intent = Intent(this, ActivityAbsenKelas::class.java)
//                intent.putExtra("email",email)
//                intent.putExtra("namakelas",namakelas)
//                TransisiActivity.transisiKeKiri_Finish(this,intent)
//            }else{
////                val intent = Intent(this, ActivityBeranda::class.java)
////                TransisiActivity.transisiKeKiri_Finish(this,intent)
//            }

        }


    }

    override fun onBackPressed() {
        tombolKembaliImageView.performClick()
    }

}