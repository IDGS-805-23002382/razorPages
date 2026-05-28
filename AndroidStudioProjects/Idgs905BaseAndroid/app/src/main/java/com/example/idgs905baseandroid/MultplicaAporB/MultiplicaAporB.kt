package com.example.idgs905baseandroid.MultplicaAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.idgs905baseandroid.R

class MultiplicaAporB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplica_apor_b)

        val edtNum1 = findViewById<EditText>(R.id.edtNum1)
        val edtNum2 = findViewById<EditText>(R.id.edtNum2)
        val btnSuma = findViewById<Button>(R.id.btnSuma)

        btnSuma.setOnClickListener {

            val num1 = edtNum1.text.toString()
            val num2 = edtNum2.text.toString()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {

                val a = num1.toInt()
                val b = num2.toInt()

                var suma = ""
                var resultado = 0

                for (i in 1..b) {

                    resultado += a

                    suma += a

                    if (i != b) {
                        suma += "+"
                    }
                }

                val operacion = "$suma = $resultado"

                val intent = Intent(this, Resultado::class.java)

                intent.putExtra("OPERACION", operacion)

                startActivity(intent)
            }
        }
    }
}