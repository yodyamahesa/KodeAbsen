package com.example.kodeabsen

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class ActivityBeranda: AppCompatActivity() {

    private lateinit var berandaSpinner: Spinner

    private fun initComponents(){
        berandaSpinner = findViewById(R.id.spinnerBerandaa)
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
    }
}