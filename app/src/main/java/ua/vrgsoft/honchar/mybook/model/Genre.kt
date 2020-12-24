package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class Genre(
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("name")
        val name: String
)