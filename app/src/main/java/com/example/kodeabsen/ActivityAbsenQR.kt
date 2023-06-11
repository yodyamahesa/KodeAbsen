package com.example.kodeabsen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ActivityAbsenQR: AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var tombolFlashImageView: ImageView
    private lateinit var tombolKembaliImageView: ImageView
    private lateinit var tombolAbsenKodeImageView: ImageView
    private lateinit var frameKameraFrameLayout: FrameLayout
    private lateinit var mScannerView: ZXingScannerView
    private lateinit var hasilScan: String
    private var flash = false;

    private fun initComponents(){
        tombolFlashImageView = findViewById(R.id.flash)
        tombolKembaliImageView = findViewById(R.id.imageView18)
        tombolAbsenKodeImageView = findViewById(R.id.imageView20)
        frameKameraFrameLayout = findViewById(R.id.frameKamera)
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
            TransisiActivity.transisiKeKanan_Finish(this,intent)
        }
    }

    override fun onBackPressed() {
        tombolKembaliImageView.performClick()
    }

    override fun handleResult(rawResult: Result?) {
        if (rawResult != null) {
            hasilScan = rawResult.text.toString()
            val intent = Intent(this, ActivityBeranda::class.java)
            TransisiActivity.transisiKeBawah_Finish(this, intent)
        }else{

        }
    }
}