package com.example.kodeabsen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ActivityAbsenQR: AppCompatActivity() {

    private lateinit var tombolFlashImageView: ImageView
    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenKodeImageView: ImageView
    private lateinit var frameKameraFrameLayout: FrameLayout
    private lateinit var mScannerView: ZXingScannerView
    private var isCaptured = false
    private var flash = 0;

    private fun initComponents(){
        tombolFlashImageView = findViewById(R.id.flash)
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenKodeImageView = findViewById(R.id.imageView20)
        frameKameraFrameLayout = findViewById(R.id.frameKamera)
    }

    private fun initScannerView() {
        mScannerView = ZXingScannerView(this)
        mScannerView.setAutoFocus(true)
        frameKameraFrameLayout.addView(mScannerView)
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
                initScannerView()
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
        doRequestPermission()
        mScannerView.startCamera()

        tombolFlashImageView.setOnClickListener{
            if(flash==0){
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_on)
                flash=1
            }else{
                tombolFlashImageView.setImageResource(R.drawable.icon_flash_off)
                flash=0
            }

        }

        tombolKembaliImageView.setOnClickListener {
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this,intent)
        }

        tombolAbsenKodeImageView.setOnClickListener {
            val intent = Intent(this, ActivityAbsenKode::class.java)
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }

    }

    override fun onBackPressed() {
        tombolKembaliImageView.performClick()
    }
}