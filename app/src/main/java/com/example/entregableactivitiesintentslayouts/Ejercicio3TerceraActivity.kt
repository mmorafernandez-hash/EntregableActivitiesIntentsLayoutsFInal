package com.example.entregableactivitiesintentslayouts


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Ejercicio3TerceraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        setContentView(R.layout.activity_ejercicio3_tercerapantalla)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscamos el botón de la cabecera por su ID
        val btnBetis = findViewById<Button>(R.id.btnbetis)

        // Al pulsar el botón, abrimos la cuarta y última actividad
        btnBetis.setOnClickListener {
            val intent = Intent(this, Ejercicio3CuartaActivity::class.java)
            startActivity(intent)
        }
    }
}