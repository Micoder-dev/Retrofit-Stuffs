package com.micoder.retrofittest.models

data class BoardList(
    val `data`: List<BoardData>,
    val message: String,
    val status: Int
)