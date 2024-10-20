package com.lopez.rosa.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallePedidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)

        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")
        val ciudad = intent.getStringExtra("ciudad") // Nueva referencia para ciudad

        val tvNombreCliente = findViewById<TextView>(R.id.tvNombreCliente)
        val tvNumeroCliente = findViewById<TextView>(R.id.tvNumeroCliente)
        val tvProducto = findViewById<TextView>(R.id.tvProducto)
        val tvUbicacion = findViewById<TextView>(R.id.tvUbicacion)

        tvNombreCliente.text = nombreCliente
        tvNumeroCliente.text = numeroCliente
        tvProducto.text = productos
        tvUbicacion.text = direccion

        val btnLlamar = findViewById<ImageView>(R.id.btnLlamar)
        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intent)
        }

        val btnWsp = findViewById<ImageView>(R.id.btnWsp)
        btnWsp.setOnClickListener {
            val uri = Uri.parse("smsto:$numeroCliente")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.setPackage("com.whatsapp")
            intent.putExtra("sms_body", "Hola $nombreCliente, tus productos: $productos están en camino a $direccion, $ciudad.")
            startActivity(intent)
        }

        val btnMaps = findViewById<ImageView>(R.id.btnMaps)
        btnMaps.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=$direccion, $ciudad")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
