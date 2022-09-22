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

        val boardApi = AssamBoardHelper.getInstance().create(API::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = boardApi.getBoards()
            val data = result.body()
            if (result != null) {
                withContext(Dispatchers.Main) {
                    boardTv.text = data!!.message
                }
            }
        }

    }
}