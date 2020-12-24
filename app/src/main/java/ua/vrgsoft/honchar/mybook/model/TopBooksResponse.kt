package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class TopBooksResponse(
        @SerializedName("top100")
        val topBooks: List<TopBooks>
)