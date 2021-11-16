package com.example.fragmentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.fragmentsexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnFragmentActionsListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate( R.menu.appbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_done -> {
            Toast.makeText(this, "Navegation to next activity", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity2::class.java))
            true
        }
        else ->{
            super.onOptionsItemSelected(item)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
      /*  toolbar = findViewById(R.id.myAppBar)
        toolbar.title = ""
        setSupportActionBar(toolbar)*/
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.myAppBar))
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "the button has been clicked", Toast.LENGTH_SHORT).show()
    }
}