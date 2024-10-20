package com.lopez.rosa.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnShow: Button
    private lateinit var btnHide: Button
    private lateinit var greenView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShow = findViewById(R.id.btnShow)
        btnHide = findViewById(R.id.btnHide)
        greenView = findViewById(R.id.greenView)

        btnShow.setOnClickListener {
            greenView.visibility = View.VISIBLE
        }

        btnHide.setOnClickListener {
            greenView.visibility = View.GONE
        }
    }
}
