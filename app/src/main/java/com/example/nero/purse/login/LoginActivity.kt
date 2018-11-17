package com.example.nero.purse.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nero.purse.R
import com.example.nero.purse.purse.PurseActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startActivity(Intent(this, PurseActivity::class.java))
    }
}
