package com.micoder.retrofittest.api

import com.micoder.retrofittest.models.BoardList
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("boards")
    suspend fun getBoards() : Response<BoardList>
}