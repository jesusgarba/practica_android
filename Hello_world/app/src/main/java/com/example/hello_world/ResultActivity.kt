package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
            btnBack.setOnClickListener { onBackPressed()
        }
        getAndShowName()
    }

    fun getAndShowName(){
        val bundle = intent.extras
        val name = bundle?.get("INTENT_NAME")
        tv_greeting.text = "Bienvenido $name"
    }
}