package com.example.sharepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.sharepreferences.SharePreferencesApplication.Companion.prefs
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initUi()
    }

    fun initUi(){
        btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        val username = prefs.getName()
        tvName.text = "Bienvenido $username"
        if (prefs.getVip()){
            setVIPColorBackground()
        }
    }

    private fun setVIPColorBackground() {
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
    }
}