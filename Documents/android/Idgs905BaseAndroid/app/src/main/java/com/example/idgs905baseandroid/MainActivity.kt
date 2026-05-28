package com.example.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.Ejemplo1.ejemplo1
import com.example.idgs905baseandroid.DistanciaDosNumeros.DistanciaDos
import com.example.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import com.example.idgs905baseandroid.ExamenResistencia.ResistenciaActivity
import com.example.idgs905baseandroid.MultplicaAporB.MultiplicaAporB
import  kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        val btnDistancia=findViewById<Button>(R.id.btn2)
        val btnEjemplo2=findViewById<Button>(R.id.btn3)
        val btnEjercicio3=findViewById<Button>(R.id.btn4)
        val btnEjercicio5=findViewById<Button>(R.id.btn5)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener { navegateToEjemplo1() }
        btnDistancia.setOnClickListener { navegateToDistanciaDos() }
        btnEjemplo2.setOnClickListener { navegateToEjemplo3() }
        btnEjercicio3.setOnClickListener { navegateToEjemplo4() }
        btnEjercicio5.setOnClickListener { navegateToResistencia() }
    }

    fun navegateToEjemplo1(){
        val intent = Intent(this, ejemplo1::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToDistanciaDos(){
        val intent = Intent(this, DistanciaDos::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToEjemplo3(){
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToEjemplo4(){
        val intent = Intent(this, MultiplicaAporB::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToResistencia(){
        val intent = Intent(this, ResistenciaActivity::class.java)
        startActivity(
            intent
        )
    }
}