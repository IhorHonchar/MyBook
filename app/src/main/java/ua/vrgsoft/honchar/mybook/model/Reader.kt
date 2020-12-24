package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class Reader(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)