package com.applab.mybmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView



class MainActivity2 : AppCompatActivity() {
    lateinit var c_view: EditText
    lateinit var r_view: EditText
    lateinit var view_chicken: TextView
    lateinit var view_rabbit: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        c_view = findViewById<EditText>(R.id.tf_chieken)
        r_view = findViewById<EditText>(R.id.tf_rabbit)
        view_chicken = findViewById<TextView>(R.id.view_CHFeet)
        view_rabbit = findViewById<TextView>(R.id.view_RAFeet)
    }

    fun calc(view: View) {
        val c = c_view.text.toString().toDouble()
        val r = r_view.text.toString().toDouble()
        val cf = (c - (r - (2 * c) / 2)) * 2
        val rf = (r - 2 * c) / 2 * 4
        view_chicken.text = "%.2f".format(cf)
        view_rabbit.text = "%.2f".format(rf)

    }
}