package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class AuthorsResponse(
        @SerializedName("authors")
        val authorsFullInfo: List<Author>,
        @SerializedName("count")
        val count: Int
)