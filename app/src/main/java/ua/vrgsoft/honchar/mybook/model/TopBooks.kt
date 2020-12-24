package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class TopBooks(
        @SerializedName("books")
        val books: List<Books>,
        @SerializedName("books_count")
        val booksCount: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("rating")
        val rating: String,
        @SerializedName("title")
        val title: String
)