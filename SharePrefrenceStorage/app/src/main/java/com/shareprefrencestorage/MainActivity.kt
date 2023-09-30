package com.shareprefrencestorage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var lastUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getName()

        var name: TextView = findViewById(R.id.editText)
        var btm: Button = findViewById(R.id.btm)

        btm.setOnClickListener() {
            saveName(name.text.toString())
        }
    }

    fun saveName(name: String) {
        var sharedPreferences: SharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("name", name)
        editor.apply()
        Toast.makeText(this, "stored", Toast.LENGTH_LONG).show()
    }

    fun getName() {
        var sharedPreferences: SharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        var name: String? = sharedPreferences.getString("name", "")

        lastUser = findViewById(R.id.lastUser)
        lastUser.text = name
    }
}
