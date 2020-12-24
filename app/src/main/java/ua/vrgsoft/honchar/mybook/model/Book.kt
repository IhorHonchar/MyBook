package ua.vrgsoft.honchar.mybook.model

import com.google.gson.annotations.SerializedName

data class Book(
        @SerializedName("authors")
        val authors: List<Author>,
        @SerializedName("description")
        val description: String,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("rating")
        val rating: Int,
        @SerializedName("readers")
        val readers: List<Reader>,
        @SerializedName("serie")
        val serie: Any,
        @SerializedName("title")
        val title: String,
        @SerializedName("totalSize")
        val totalSize: Int,
        @SerializedName("totalTime")
        val totalTime: Int,
        @SerializedName("tracks")
        val tracks: List<Track>
)