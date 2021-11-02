package com.example.hello_world

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShowName.setOnClickListener {
            checkValue()
        }

    }

    fun checkValue(){
        if (etName.text.isNotEmpty()){
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("INTENT_NAME", etName.text)
            startActivity(intent)
        } else {
           showErrorName()
        }
    }

    fun showErrorName(){
        Toast.makeText(this, "el nombre del usuario no puede ser vacío", Toast.LENGTH_SHORT).show();
    }
}