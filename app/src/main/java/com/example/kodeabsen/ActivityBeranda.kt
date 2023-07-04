package com.example.kodeabsen

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder


class ActivityBeranda: AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var absenImageView: ImageView
    private lateinit var tambahImageView: ImageView
    private lateinit var cobaImageView: ImageView
    private lateinit var QrBitmap: Bitmap
    private lateinit var email: String
    private var QrString = ""

    private fun initComponents(){

        profileImageView = findViewById(R.id.imageView3)
        absenImageView = findViewById(R.id.imageView2)
        tambahImageView = findViewById(R.id.imageView4)
        cobaImageView = findViewById(R.id.imageView17)
    }

    private fun qrStringToBitmap(){
        val encoder = BarcodeEncoder()
        QrBitmap = encoder.encodeBitmap(QrString, BarcodeFormat.QR_CODE, 400, 400)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val extras = intent.extras
        if (extras != null) {
            email = (extras.getString("email")).toString()
            QrString = (extras.getString("hasilScan")).toString()
        }

        initComponents()

        if(QrString != ""){
            qrStringToBitmap()
            cobaImageView.setImageBitmap(QrBitmap)
        }


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
                intent.putExtra("email",email)
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