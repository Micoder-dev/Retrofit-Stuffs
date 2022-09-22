package com.micoder.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.micoder.retrofittest.api.API
import com.micoder.retrofittest.helpers.AssamBoardHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardTv = findViewById<TextView>(R.id.tvBoard)
        val classTv = findViewById<TextView>(R.id.tvClass)

        val Api = AssamBoardHelper.getInstance().create(API::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val boardResult = Api.getBoards()
            val boardData = boardResult.body()
            if (boardResult != null) {
                withContext(Dispatchers.Main) {
                    boardTv.text = boardData!!.message
                }
            }
            val classResult = Api.getClasses()
            val classData = classResult.body()
            if (classResult != null) {
                withContext(Dispatchers.Main) {
                    classTv.text = classData!!.message
                }
            }
        }

    }
}