package com.applab.app_exchange

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        // 配置 spinner 的下拉選單資料
        val symbols = arrayOf("USD", "JPY", "CNY", "AUD", "EUR")
        // 適配器 adapter (管理資料與資料UI的配置)
        // 正常樣貌
        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, symbols)
        // 下拉後樣貌
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter


    }

    fun onClick(view: View) {

        val intent = Intent(context, ExchangeActivity::class.java)
        intent.putExtra("amount", input_twd.text.toString().toInt())
        intent.putExtra("symbol", spinner.selectedItem.toString())
        startActivity(intent)
    }

}