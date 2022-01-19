package com.musnadil.suitmediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second_screen.*

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        var actionBar = getSupportActionBar()
        // set nama activity pada actionbar
        actionBar!!.title = "Second Screen"
        // menampilkan back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val intent = intent
        var nama = intent.getStringExtra("nama")
        tvUsername.text = nama.toString()

        btnChooseUser.setOnClickListener {
            startActivity(Intent (this,ThirdScreen::class.java))
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}