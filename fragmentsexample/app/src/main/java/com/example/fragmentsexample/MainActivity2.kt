package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentsexample.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), OnFragmentActionsListener {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blueButtonId.setOnClickListener { replaceFragment(BlueFragment()) }
        binding.redButtonId.setOnClickListener { replaceFragment(RedFragment()) }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment)
        fragmentTransition.addToBackStack(null)
        fragmentTransition.commit()
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "the button has been clicked", Toast.LENGTH_SHORT).show()
    }

}