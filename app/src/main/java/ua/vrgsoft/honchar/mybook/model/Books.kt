package ua.vrgsoft.honchar.mybook.model


import com.google.gson.annotations.SerializedName

data class Books(
        @SerializedName("books")
        val books: List<Book>,
        @SerializedName("count")
        val count: Int
)