package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.room.R.layout.activity_main2
import com.example.room.databinding.ActivityMain2Binding
import com.example.room.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initAct2()
    }

    private fun initAct2() {
        binding.btnHide.setOnClickListener {
            Log.i("boton","has pulsado boton hide y tiene una estado --> ${binding.ivTrademark.visibility}")
            if (binding.ivTrademark.visibility == View.VISIBLE)  {
                binding.ivTrademark.visibility = View.INVISIBLE
                binding.btnHide.text = "VIEW"
            } else {
                binding.ivTrademark.visibility = View.VISIBLE
                binding.btnHide.text = "HIDE"
            }
        }
    }
}