package com.micoder.retrofittest.helpers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AssamBoardHelper {

    val baseUrl = "https://assamboard.devlibrary.in/api/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}