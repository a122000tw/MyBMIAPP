package com.applab.app_exchange

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
    }

    fun onClick(view: View) {

        val intent = Intent(context, ExchangeActivity::class.java)
        intent.putExtra("amount", input_twd.text.toString().toInt())
        startActivity(intent)
    }

}