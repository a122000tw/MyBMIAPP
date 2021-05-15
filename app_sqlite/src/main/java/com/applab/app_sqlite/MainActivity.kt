package com.applab.app_sqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.applab.app_sqlite.db.DBHelper
import com.applab.app_sqlite.models.Student
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val dbHelper = DBHelper(this)
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        title = dbHelper.databaseName
        // 按下新增
        btn_create.setOnClickListener {
            create()
        }

        // 按下修改
        btn_update.setOnClickListener {
            update()
        }
        // 按下刪除
        btn_delete.setOnClickListener {
            delete()
        }
        // 按下查詢
        btn_read.setOnClickListener {
            readAll()
        }

    }
    // 新增紀錄
    fun create() {
        val name = et_name.text.toString()
        val score = et_score.text.toString()
        dbHelper.createStudent(name, score.toInt())
        cleanFields()
    }
    // 修改紀錄
    fun update() {
        val id = et_id.text.toString()
        val name = et_name.text.toString()
        val score = et_score.text.toString()
        val ct = Date().time
        val student = Student(id.toInt(), name, score.toInt(), ct)
        dbHelper.updateStudent(student)
        cleanFields()
    }
    // 刪除紀錄
    fun delete() {
        val id = et_id.text.toString()
        dbHelper.deleteStudent(id.toInt())
        cleanFields()
    }
    // 查詢紀錄
    fun readAll() {
        val stuendts = dbHelper.readAllStudent()
        // Toast.makeText(context, stuendts.toString(), Toast.LENGTH_SHORT).show()
    }


    // 清除欄位資料
    fun cleanFields() {
        et_id.setText("")
        et_name.setText("")
        et_score.setText("")
    }

}