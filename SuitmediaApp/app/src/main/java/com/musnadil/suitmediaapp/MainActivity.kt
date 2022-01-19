package com.musnadil.suitmediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        var actionbar = getSupportActionBar()
        actionbar?.hide()

        btnNext.setOnClickListener { getData() }
        btnCheck.setOnClickListener {
            var textPalindrome = etPalindrome.text.toString()
            val dialogPalindrome = AlertDialog.Builder(this)

            if (textPalindrome.isEmpty()){
                dialogPalindrome.apply {
                    setMessage("The text is null")
                    setNegativeButton("OK"){dialog,which->
                        dialog.dismiss()
                    }
                }
                dialogPalindrome.show()
            }else if(checkPalindrome(textPalindrome)){
                dialogPalindrome.apply {
                    setMessage("The text is Palindrome")
                    setNegativeButton("OK"){dialog,which->
                        dialog.dismiss()
                    }
                }
                etPalindrome.text = null
                dialogPalindrome.show()
            }else{
                dialogPalindrome.apply {
                    setMessage("The text is not Palindrome")
                    setNegativeButton("OK"){dialog,which->
                        dialog.dismiss()
                    }
                }
                etPalindrome.text = null
                dialogPalindrome.show()
            }
        }

    }
    fun getData(){
        var nama = etName.text.toString()
        if (nama.isEmpty()){
            Toast.makeText(this,"Nama masih kosong",Toast.LENGTH_SHORT).show()
            etName.requestFocus()
        }else {
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("nama", nama)
            startActivity(intent)
            etName.text = null
        }
    }
    private fun checkPalindrome(textPalindrome:String):Boolean{
        val reverseString = textPalindrome.reversed().toString()
        return textPalindrome.equals(reverseString,ignoreCase = true)

    }
}