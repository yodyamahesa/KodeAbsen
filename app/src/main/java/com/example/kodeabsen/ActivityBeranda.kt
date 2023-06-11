package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ActivityBeranda: AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var absenImageView: ImageView
    private lateinit var tambahImageView: ImageView

    private fun initComponents(){

        profileImageView = findViewById(R.id.imageView3)
        absenImageView = findViewById(R.id.imageView2)
        tambahImageView = findViewById(R.id.imageView4)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        initComponents()

        profileImageView.setOnClickListener {
            val intent = Intent(this, ActivityProfile::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }

        absenImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenQR::class.java)
            TransisiActivity.transisiKeAtas_Finish(this,intent)
        }

        tambahImageView.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.opsi_tambah, null)
            val buttonTambahKelas = dialogView.findViewById<Button>(R.id.button_tambah_kelas)
            val buttonGabungKelas = dialogView.findViewById<Button>(R.id.button_gabung_kelas)
            val buttonBatal = dialogView.findViewById<Button>(R.id.button_batal)

            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)

            val dialog = dialogBuilder.create()
            dialog.show()

            buttonTambahKelas.setOnClickListener {
                // Aksi untuk Menambahkan Kelas
                // Tambahkan kode yang sesuai di sini
                dialog.dismiss()
                val intent = Intent(this,ActivityBuatKelas1::class.java)
                TransisiActivity.transisiKeAtas_Finish(this,intent)
            }

            buttonGabungKelas.setOnClickListener {
                // Aksi untuk Gabung Kelas
                // Tambahkan kode yang sesuai di sini
                dialog.dismiss()
            }

            buttonBatal.setOnClickListener {
                dialog.dismiss()
            }
        }


    }
}