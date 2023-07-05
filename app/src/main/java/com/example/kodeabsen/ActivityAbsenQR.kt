package com.example.kodeabsen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ActivityAbsenQR: AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var tombolFlashImageView: ImageView
    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenKodeImageView: ImageView
    private lateinit var frameKameraFrameLayout: FrameLayout
    private lateinit var mScannerView: ZXingScannerView
    private lateinit var hasilScan: String
    private lateinit var kodemasuk: String
    private lateinit var database: DatabaseReference
    private lateinit var email: String
    private lateinit var emailku: String
    private var flash = false;

    private fun initComponents(){
        tombolFlashImageView = findViewById(R.id.flash)
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenKodeImageView = findViewById(R.id.imageView20)
        frameKameraFrameLayout = findViewById(R.id.frameKamera)
        database = Firebase.database.reference

    }

    private fun initScannerView() {
        doRequestPermission()
        mScannerView = ZXingScannerView(this)
        mScannerView.setAutoFocus(true)
        mScannerView.setResultHandler(this)
        frameKameraFrameLayout.addView(mScannerView)
        mScannerView.startCamera()
    }

    private fun doRequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }
        }
    }

     override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 -> {

            }
            else -> {
                /* nothing to do in here */
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen_qr)

        initComponents()
        initScannerView()

        val extras = intent.extras
        if (extras != null) {
            emailku = (extras.getString("email")).toString()
        }

        tombolFlashImageView.setOnClickListener{
            if(flash==false){
                mScannerView.flash = true
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_on)
                flash=true
            }else{
                mScannerView.flash = false
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_off)
                flash=false
            }
        }

        tombolKembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)
        }

        tombolAbsenKodeImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenKode::class.java)
            intent.putExtra("email",emailku)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }
    }

    override fun onBackPressed() {
        tombolKembaliImageView.performClick()
    }

    override fun handleResult(rawResult: Result?) {
        if (rawResult != null) {
            hasilScan = rawResult.text.toString()

            database.child("kelas").child(hasilScan).get().addOnSuccessListener {
                val namakelas = it.child("namaKelas").value.toString()
                val email = it.child("email").value.toString()
                val kodemasuk = it.child("kodekelas").value.toString()
                if(hasilScan==kodemasuk){
                    val intent = Intent(this, ActivityAbsenKelas::class.java)
                    intent.putExtra("email",email)
                    intent.putExtra("namakelas",namakelas)
                    intent.putExtra("kode",kodemasuk)
                    TransisiActivity.transisiKeKanan_Finish(this,intent)
                }else{
                    val intent = Intent(this,ActivityBeranda::class.java)
                    intent.putExtra("hasilScan", hasilScan)
                    TransisiActivity.transisiKeBawah_Finish(this, intent)
                }
            }.addOnFailureListener{
                val intent = Intent(this,ActivityBeranda::class.java)
                intent.putExtra("hasilScan", hasilScan)
                TransisiActivity.transisiKeBawah_Finish(this, intent)
            }
        }else{

        }
    }
}