package com.applab.app_abnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.applab.app_abnumber.utils.ABNumber
import java.util.*

class MainActivity : AppCompatActivity() {

    private var ab = ABNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ab.setAns()
    }

    fun onClickSubmitButton(view: View) {
        val guess = "1234"
        val result = ab.getResult(guess)
        Log.d("MainActivity", Arrays.toString(result))
        if(result[0] == 4) {

        }



    }
}