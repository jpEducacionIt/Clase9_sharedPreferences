package com.example.clase9sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button = findViewById(R.id.button2)
        editText = findViewById(R.id.etext2)

        button.setOnClickListener {
            if (editText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show()
            } else {
                val nombre: String = editText.text.toString()
                val pref = getSharedPreferences("appPref", MODE_PRIVATE)
                val editor = pref.edit().putString(SHARED_PREFERENCE_NAME, nombre)
                editor.apply()
                startActivity(Intent(this, SplashActivity::class.java))
            }
        }
    }

    companion object {
        const val SHARED_PREFERENCE_NAME = "name"
    }
}