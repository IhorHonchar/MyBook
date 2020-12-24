package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class Author(
        @SerializedName("books_count")
        val booksCount: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)