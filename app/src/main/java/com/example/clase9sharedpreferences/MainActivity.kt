package com.example.clase9sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button3)
        textView = findViewById(R.id.textView)

        val pref = getSharedPreferences("appPref", MODE_PRIVATE)
        val nombreUser = pref.getString(SHARED_PREFERENCE_NAME, "")
        textView.text = nombreUser

        button.setOnClickListener {
            pref.edit().remove(SHARED_PREFERENCE_NAME).apply()
            startActivity(Intent(this, SplashActivity::class.java))
        }
    }

    companion object {
        const val SHARED_PREFERENCE_NAME = "name"
    }
}