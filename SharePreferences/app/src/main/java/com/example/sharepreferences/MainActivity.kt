package com.example.sharepreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharepreferences.SharePreferencesApplication.Companion.prefs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }

    fun initUi(){
       btnContinue.setOnClickListener {
           accessDetail()
       }
    }

    fun accessDetail(){
        if(etName.text.toString().isNotEmpty()){
            prefs.saveName(etName.text.toString())
            prefs.saveVip(cbVip.isChecked)
            goToDetail()
        }else{
           //TODO: hacer otra cosa
        }
    }

    fun goToDetail(){
        startActivity(Intent(this, ResultActivity::class.java))
    }
}