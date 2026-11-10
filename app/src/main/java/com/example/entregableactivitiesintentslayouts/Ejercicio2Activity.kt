package com.example.entregableactivitiesintentslayouts


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carga la interfaz gráfica correspondiente definida en activity_ejercicio2.xml
        setContentView(R.layout.activity_ejercicio2)

        val bt = findViewById<Button>(R.id.btnEjecutarRetraso)

        // es decir esto lo que hace es que cuando pulse el boton se finalize la accion
        bt.setOnClickListener {
            finish()
        }
    }
}