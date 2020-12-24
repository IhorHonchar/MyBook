package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class Track(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("time")
        val time: Int,
        @SerializedName("url")
        val url: String
)