package com.example.entregableactivitiesintentslayouts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etUrl: EditText = findViewById(R.id.etUrl)
        val btnAbrirUrl: Button = findViewById(R.id.btnAbrirUrl)

        btnAbrirUrl.setOnClickListener {
            var urlTexto = etUrl.text.toString().trim()

            if (urlTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, introduce una URL válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Añadir el esquema http/https si el usuario no lo escribió
            if (!urlTexto.startsWith("http://") && !urlTexto.startsWith("https://")) {
                urlTexto = "https://$urlTexto"
            }

            // Validar la URL usando Patterns de Android
            if (Patterns.WEB_URL.matcher(urlTexto).matches()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlTexto))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, introduce una URL válida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}