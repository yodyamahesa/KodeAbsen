package com.example.kodeabsen

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ActivityBeranda: AppCompatActivity() {

    private lateinit var berandaSpinner: Spinner
    private lateinit var profileImageView: ImageView
    private lateinit var absenImageView: ImageView
    private lateinit var tambahImageView: ImageView

    private fun initComponents(){
        berandaSpinner = findViewById(R.id.spinnerBerandaa)
        profileImageView = findViewById(R.id.imageView3)
        absenImageView = findViewById(R.id.imageView2)
        tambahImageView = findViewById(R.id.imageView4)
    }

    private fun isiSpinner(){
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_beranda,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            berandaSpinner.adapter = adapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        initComponents()
        isiSpinner()

        profileImageView.setOnClickListener {
            val keActivityProfile = Intent(this, ActivityProfile::class.java)
            startActivity(keActivityProfile)
            finish()
        }

        absenImageView.setOnClickListener {
            val keActivityAbsenQR = Intent(this, ActivityAbsenQR::class.java)
            startActivity(keActivityAbsenQR)
            finish()
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