package com.example.idgs905baseandroid.MultplicaAporB

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.idgs905baseandroid.R

class Resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val operacion = intent.getStringExtra("OPERACION")

        tvResultado.text = operacion
    }
}