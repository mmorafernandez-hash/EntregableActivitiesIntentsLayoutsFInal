package com.example.entregableactivitiesintentslayouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        setContentView(R.layout.activity_ejercicio3_segundapantalla)

        // Ajuste para evitar solapamientos con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscamos el botón por su ID btnsevillafc
        val btnSevilla = findViewById<Button>(R.id.btnsevillafc)

        // Al pulsar avanza hacia la tercera Activity
        btnSevilla.setOnClickListener {
            val intent = Intent(this, Ejercicio3TerceraActivity::class.java)
            startActivity(intent)
        }
    }
}