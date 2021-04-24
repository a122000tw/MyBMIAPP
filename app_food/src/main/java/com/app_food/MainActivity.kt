package com.app_food

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        service()
    }

    private fun service() {
        // 1. 抓 assets 資料夾下的 foods.json
        var json = assets.open("foods.json").bufferedReader().use {
            it.readText() }
        // Log.d("MainActivity", json)
        // 2. 將 json 字串轉成 foods 陣列(List)
        var foods = Gson().fromJson(json, Array<Food>::class.java).toList()
        // Log.d("MainActivity", foods.toString())
        // 3. 建立適配器給 adapter 給 gird_view 使用
        val adapter = object : ArrayAdapter<Food>(
            context,
            R.layout.item,
            R.id.text_name,
            foods) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                // 這裡指的就是 R.layout.item 所配置的物件
                val v =  super.getView(position, convertView, parent)
                val food = getItem(position) // 得到 food 物件資料
                val textName = v.text_name
                val textPrice = v.text_price
                val imgFood = v.image_food
                val imgSpicy = v.image_spicy
                val imgNew = v.image_new
                val imgFoodId = resources.getIdentifier(food?.idName,"drawable", packageName)
                textName.text = food?.name
                textPrice.text = food?.price.toString()
                imgFood.setImageResource(imgFoodId)
                if (food!!.spicy) {
                    imgSpicy.setImageResource(R.drawable.isspicy)
                } else {
                    imgSpicy.setImageResource(android.R.color.transparent)
                }
                if (food.new) {
                    imgNew.setImageResource(R.drawable.isnew)
                } else {
                    imgNew.setImageResource(android.R.color.transparent)
                }

                return v
            }
        }
        // 4. 配置 adapter 給 grid_view
        grid_view.adapter = adapter

        //
        grid_view.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val food = parent?.getItemAtPosition(position) as Food
                val imageId = resources.getIdentifier(food.idName, "drawable", packageName)
                image_food.setImageResource(imageId)
                text_name.text = food.name
                text_price.text = food.price.toString()

                if (food.spicy) {
                    image_spicy.setImageResource(R.drawable.isspicy)
                } else {
                    image_spicy.setImageResource(android.R.color.transparent)
                }
                if (food.new) {
                    image_new.setImageResource(R.drawable.isnew)
                } else {
                    image_new.setImageResource(android.R.color.transparent)
                }

            }

    }



}