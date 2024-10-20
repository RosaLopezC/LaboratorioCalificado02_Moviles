package com.lopez.rosa.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Ejercicio02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        val etNombreCliente = findViewById<EditText>(R.id.etNombreCliente)
        val etNumeroCliente = findViewById<EditText>(R.id.etNumeroCliente)
        val etProductos = findViewById<EditText>(R.id.etProductos)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etCiudad = findViewById<EditText>(R.id.etCiudad) // Nueva referencia a la ciudad

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            val nombreCliente = etNombreCliente.text.toString()
            val numeroCliente = etNumeroCliente.text.toString()
            val productos = etProductos.text.toString()
            val direccion = etDireccion.text.toString()
            val ciudad = etCiudad.text.toString() // Ciudad

            if (nombreCliente.isNotEmpty() && numeroCliente.isNotEmpty() && productos.isNotEmpty() && direccion.isNotEmpty() && ciudad.isNotEmpty()) {
                val intent = Intent(this, DetallePedidoActivity::class.java).apply {
                    putExtra("nombreCliente", nombreCliente)
                    putExtra("numeroCliente", numeroCliente)
                    putExtra("productos", productos)
                    putExtra("direccion", direccion)
                    putExtra("ciudad", ciudad) // Enviamos la ciudad
                }
                startActivity(intent)
            } else {
            }
        }
    }
}
