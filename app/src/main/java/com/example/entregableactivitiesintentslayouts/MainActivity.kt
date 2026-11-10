package com.example.entregableactivitiesintentslayouts

// Importaciones necesarias para que Android reconozca botones, intents, temporizadores, etc.
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Activa el diseño de borde a borde
        enableEdgeToEdge()

        // Carga la interfaz gráfica definida en activity_main.xml
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1: Button = findViewById(R.id.btnEjercicio1)
        val btn2: Button = findViewById(R.id.btnEjercicio2)
        val btn3: Button = findViewById(R.id.btnEjercicio3)
        val btn4: Button = findViewById(R.id.btnEjercicio4)
        val btn5: Button = findViewById(R.id.btnEjercicio5)
        val btn6: Button = findViewById(R.id.btnEjercicio6)

        // boton pulsas y abres ejercicio 1
        btn1.setOnClickListener {
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        // Al pulsar el Botón 2: espera 7 segundos antes de abrir el Ejercicio 2
        btn2.setOnClickListener {
            // Muestra un mensaje emergente avisando del retardo
            Toast.makeText(this, "Navegación diferida: esperando 7 segundos...", Toast.LENGTH_SHORT).show()

            // Preparamos la intención de ir a Ejercicio2Activity
            val intent = Intent(this, Ejercicio2Activity::class.java)

            // Handler para programar una tarea diferida en 7 segundos
            Handler(Looper.getMainLooper()).postDelayed({
                // Comprobamos que la pantalla principal siga abierta para evitar errores si el usuario salió
                if (!isFinishing && !isDestroyed) {
                    startActivity(intent)
                }
            }, 7000)
        }

        // boton pulsas y abres ejercicio 3
        btn3.setOnClickListener {
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        // boton pulsas y abres ejercicio 4
        btn4.setOnClickListener {
            val intent = Intent(this, Ejercicio4Activity::class.java)
            startActivity(intent)
        }

        // boton pulsas y abres ejercicio 5
        btn5.setOnClickListener {
            val intent = Intent(this, Ejercicio5Activity::class.java)
            startActivity(intent)
        }

        // boton pulsas y abres ejercicio 6
        btn6.setOnClickListener {
            val intent = Intent(this, Ejercicio6Activity::class.java)
            startActivity(intent)
        }
    }
}