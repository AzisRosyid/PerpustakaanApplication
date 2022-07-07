package com.example.perpustakaanapplication

import java.io.Serializable

data class Book(
    val title: String,
    val author: String,
    val category: String,
    val language: String,
    val pages: Int,
    val description: String,
    val photo: Int,
    val file: String
): Serializable
