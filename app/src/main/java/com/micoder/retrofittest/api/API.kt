package com.micoder.retrofittest.api

import com.micoder.retrofittest.models.BoardList
import com.micoder.retrofittest.models.ClassList
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("boards")
    suspend fun getBoards() : Response<BoardList>
    @GET("classes")
    suspend fun getClasses() : Response<ClassList>
}