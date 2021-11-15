package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.fragmentsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentActionsListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "the button has been clicked", Toast.LENGTH_SHORT).show()
    }
}