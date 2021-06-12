package com.bhanu.sharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var userName : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.userName)

        val sharedPreferences = getSharedPreferences("MYPREFERENCEFILE", Context.MODE_PRIVATE)
        userName.setText(sharedPreferences.getString("USERNAME", "AndroidApp"))
    }

    override fun onPause() {
        super.onPause()

        val sharedPreferences = getSharedPreferences("MYPREFERENCEFILE", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("USERNAME", userName.text.toString())
        editor.apply()
    }
}