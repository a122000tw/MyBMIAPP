package com.applab.app_parking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        var json = assets.open("parking.json").bufferedReader().use { it.readText() }
        val jelement: JsonElement = JsonParser.parseString(json)
        val result = jelement.asJsonObject.getAsJsonObject("result")
        val records = result.getAsJsonArray("records")

        val listType: Type = object : TypeToken<List<Map<String?, Object?>?>?>() {}.type

        val list: List<Map<String, Object>> = Gson().fromJson(records.toString(), listType)
        Log.d("MainActivity", list.toString())

        recycler_view.adapter = ParkingAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        // recycler 優化 (固定 item 尺寸)
        recycler_view.setHasFixedSize(true)

    }
}