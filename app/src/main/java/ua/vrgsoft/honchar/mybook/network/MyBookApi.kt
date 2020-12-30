package ua.vrgsoft.honchar.mybook.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.vrgsoft.honchar.mybook.model.AuthorsResponse
import ua.vrgsoft.honchar.mybook.model.Book
import ua.vrgsoft.honchar.mybook.model.Books
import ua.vrgsoft.honchar.mybook.model.TopBooksResponse

interface MyBookApi {
    @GET("authors/list")
    fun getAuthorsList(@Query("limit") limit: Int, @Query("offset") offset: Int ) : Call<AuthorsResponse>

    @GET("authors/search")
    fun searchAuthors(@Query("q") q:String, @Query("limit") limit:Int, @Query("offset") offset:Int) : Call<AuthorsResponse>

    @GET("books/top")
    fun getTopBooks(@Query("limit") limit:Int, @Query("offset") offset:Int) : Call<TopBooksResponse>

    @GET("books/{id}")
    fun getBookInfo(@Path("id") id:Int) : Call<Book>

    @GET("books/list-by-author")
    fun getBooksByAuthor(@Query("author_id") id:Int, @Query("limit") limit: Int, @Query("offset") offset: Int) : Call<Books>

    @GET("books/popular")
    fun getPopularBooks(@Query("limit") limit: Int, @Query("offset") offset: Int) : Call<Books>
}
