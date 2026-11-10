package com.example.entregableactivitiesintentslayouts

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio5Activity : AppCompatActivity() {

    // === DECLARACIÓN DE VARIABLES DE ESTADO ===
    // Guardará la referencia a la caja de texto (TextView) del resultado
    private lateinit var tvResultado: TextView

    // Almacena el primer valor numérico antes de pulsar una operación (+, -, *, /)
    private var primerNumero = 0.0

    // Guarda el símbolo de la operación aritmética seleccionada
    private var operacion = ""

    // Controla si el próximo dígito debe limpiar la pantalla o agregarse al número actual
    private var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que la vista ocupe los bordes completos de la pantalla
        enableEdgeToEdge()

        // Enlaza la Activity con su maquetación XML (TableLayout)
        setContentView(R.layout.activity_ejercicio5)

        // Ajusta los márgenes para no solaparse con las barras de estado y navegación del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // === INICIALIZACIÓN DE LA VISTA ===
        tvResultado = findViewById(R.id.tvResultado)

        // === CONFIGURACIÓN DE BOTONES NUMÉRICOS (0-9) ===
        // Lista con los IDs de todos los botones de números del XML
        val botonesNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        // Recorremos la lista para asignar el evento de clic a cada botón numérico
        for (id in botonesNumeros) {
            findViewById<Button>(id).setOnClickListener { btn ->
                // Captura el texto del botón presionado (ej: "7") y lo manda a procesar
                val numero = (btn as Button).text.toString()
                numeroPulsado(numero)
            }
        }

        // === CONFIGURACIÓN DEL SEPARADOR DECIMAL (.) ===
        findViewById<Button>(R.id.btnPunto).setOnClickListener {
            if (nuevoNumero) {
                // Si viene de elegir una operación, muestra "0." para iniciar el decimal
                tvResultado.text = "0."
                nuevoNumero = false
            } else if (!tvResultado.text.contains(".")) {
                // Añade el punto solo si la cifra actual no tiene uno previo
                tvResultado.text = "${tvResultado.text}."
            }
        }

        // === CONFIGURACIÓN DE OPERADORES (+, -, *, /) ===
        // Mapa que vincula el ID de cada botón con su símbolo de operación
        val operaciones = mapOf(
            R.id.btnSuma to "+",
            R.id.btnResta to "-",
            R.id.btnMult to "*",
            R.id.btnDiv to "/"
        )

        // Asigna el evento OnClickListener a cada botón de operación
        for ((id, op) in operaciones) {
            findViewById<Button>(id).setOnClickListener {
                operacionPulsada(op)
            }
        }

        // === CONFIGURACIÓN DEL BOTÓN IGUAL (=) ===
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            calcularResultado()
        }

        // === CONFIGURACIÓN DEL BOTÓN RESTABLECER (C) ===
        // Limpia los valores y devuelve la calculadora a su estado inicial
        findViewById<Button>(R.id.btnC).setOnClickListener {
            tvResultado.text = "0"
            primerNumero = 0.0
            operacion = ""
            nuevoNumero = true
        }
    }

    // === LÓGICA: ESCRIBIR UN NÚMERO ===
    private fun numeroPulsado(num: String) {
        if (nuevoNumero || tvResultado.text == "0") {
            // Sustituye el texto si es una nueva entrada o si estaba el "0" inicial
            tvResultado.text = num
            nuevoNumero = false
        } else {
            // Concatena el nuevo dígito a la derecha del existente
            tvResultado.text = "${tvResultado.text}$num"
        }
    }

    // === LÓGICA: SELECCIONAR OPERACIÓN ===
    private fun operacionPulsada(op: String) {
        // Guarda el número actual mostrado en pantalla como primer operando
        primerNumero = tvResultado.text.toString().toDoubleOrNull() ?: 0.0
        // Registra el tipo de operación elegida (+, -, *, /)
        operacion = op
        // Prepara la pantalla para recibir el segundo operando
        nuevoNumero = true
    }

    // === LÓGICA: CALCULAR Y MOSTRAR RESULTADO ===
    private fun calcularResultado() {
        // Si no hay operación registrada, se omite el cálculo
        if (operacion.isEmpty()) return

        // Captura el segundo valor presente en pantalla
        val segundoNumero = tvResultado.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = 0.0

        // Aplica el operador correspondiente
        when (operacion) {
            "+" -> resultado = primerNumero + segundoNumero
            "-" -> resultado = primerNumero - segundoNumero  // Operador corregido
            "*" -> resultado = primerNumero * segundoNumero  // Operador corregido
            "/" -> resultado = if (segundoNumero != 0.0) primerNumero / segundoNumero else 0.0
        }

        // Formatea el resultado para omitir decimales si es un valor entero (ej: 5.0 -> 5)
        val resTexto = if (resultado % 1 == 0.0) {
            resultado.toLong().toString()
        } else {
            resultado.toString()
        }

        // Muestra la cifra en pantalla y resetea la operación
        tvResultado.text = resTexto
        operacion = ""
        nuevoNumero = true
    }
}