package com.applab.mybmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var h_view: EditText
    lateinit var w_view: EditText
    lateinit var result_view: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        h_view = findViewById<EditText>(R.id.tf_height)
        w_view = findViewById<EditText>(R.id.tf_weight)
        result_view = findViewById<TextView>(R.id.result_view)
    }

    // 使用者按下 btn_calc 所要做的事
    fun calc(view: View) {
        val h = findViewById<EditText>(R.id.tf_height).text.toString().toDouble()
        val w = findViewById<EditText>(R.id.tf_weight).text.toString().toDouble()
        val bmi = w / (h / 100).pow(2.0)
        // 利用 Toast 顯示 bmi 的計算值
        Toast.makeText(this, "%.2f".format(bmi), Toast.LENGTH_SHORT).show()
        result_view.text = "%.2f".format(bmi)
    }
}