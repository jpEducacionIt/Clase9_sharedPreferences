package com.example.clase9sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SplashActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textViewNombre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        button = findViewById(R.id.button)
        textViewNombre = findViewById(R.id.textViewNombreUser)

        val pref = getSharedPreferences("appPref", MODE_PRIVATE)
        val nombreUser = pref.getString(SHARED_PREFERENCE_NAME, "")

        if (nombreUser != null) {
            if(nombreUser.isEmpty()) {
                button.text = "registrar"
                button.setOnClickListener {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
            } else {
                button.text = "ingresar"
                textViewNombre.text = nombreUser
                button.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    companion object {
        const val SHARED_PREFERENCE_NAME = "name"
    }
}