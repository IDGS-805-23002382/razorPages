package com.example.idgs905baseandroid.ExamenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R
import kotlin.math.roundToInt

class ResistenciaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resistencia)

        val spColor1 = findViewById<Spinner>(R.id.spColor1)
        val spColor2 = findViewById<Spinner>(R.id.spColor2)
        val spMultiplicador = findViewById<Spinner>(R.id.spMultiplicador)

        val txtColor1 = findViewById<TextView>(R.id.txtColor1)
        val txtColor2 = findViewById<TextView>(R.id.txtColor2)
        val txtMultiplicador = findViewById<TextView>(R.id.txtMultiplicador)

        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val tvOhm = findViewById<TextView>(R.id.tvOhm)
        val tvMaximo = findViewById<TextView>(R.id.tvMaximo)
        val tvMinimo = findViewById<TextView>(R.id.tvMinimo)

        val colores = arrayOf(
            "Negro",
            "Cafe",
            "Rojo",
            "Naranja",
            "Amarillo",
            "Verde",
            "Azul",
            "Violeta",
            "Gris",
            "Blanco"
        )

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            colores
        )

        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spColor1.adapter = adaptador
        spColor2.adapter = adaptador
        spMultiplicador.adapter = adaptador

        fun obtenerColor(posicion: Int): Int {

            return when (posicion) {

                0 -> Color.BLACK
                1 -> Color.rgb(139, 69, 19)
                2 -> Color.RED
                3 -> Color.rgb(255, 165, 0)
                4 -> Color.YELLOW
                5 -> Color.GREEN
                6 -> Color.BLUE
                7 -> Color.MAGENTA
                8 -> Color.GRAY
                9 -> Color.WHITE

                else -> Color.WHITE
            }
        }

        // COLOR 1

        spColor1.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    txtColor1.setBackgroundColor(
                        obtenerColor(position)
                    )

                    if (position == 0) {
                        txtColor1.setTextColor(Color.WHITE)
                    } else {
                        txtColor1.setTextColor(Color.BLACK)
                    }

                    txtColor1.text = position.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        // COLOR 2

        spColor2.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    txtColor2.setBackgroundColor(
                        obtenerColor(position)
                    )

                    if (position == 0) {
                        txtColor2.setTextColor(Color.WHITE)
                    } else {
                        txtColor2.setTextColor(Color.BLACK)
                    }

                    txtColor2.text = position.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        // MULTIPLICADOR

        spMultiplicador.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    txtMultiplicador.setBackgroundColor(
                        obtenerColor(position)
                    )

                    if (position == 0) {
                        txtMultiplicador.setTextColor(Color.WHITE)
                    } else {
                        txtMultiplicador.setTextColor(Color.BLACK)
                    }

                    txtMultiplicador.text = "10^$position"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        // BOTON CALCULAR

        btnCalcular.setOnClickListener {

            val banda1 = spColor1.selectedItemPosition
            val banda2 = spColor2.selectedItemPosition
            val multiplicador = spMultiplicador.selectedItemPosition

            val numero = "$banda1$banda2".toInt()

            val valorOhm =
                numero * Math.pow(
                    10.0,
                    multiplicador.toDouble()
                ).toInt()

            val tolerancia =
                if (rgTolerancia.checkedRadioButtonId == R.id.rbOro) {
                    0.05
                } else {
                    0.10
                }
            val maximo =
                (valorOhm + (valorOhm * tolerancia))

            val minimo =
                (valorOhm - (valorOhm * tolerancia))

            tvOhm.text = "Valor Ohm: $valorOhm Ω"
            tvMaximo.text = "Valor Máximo: $maximo Ω"
            tvMinimo.text = "Valor Mínimo: $minimo Ω"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}