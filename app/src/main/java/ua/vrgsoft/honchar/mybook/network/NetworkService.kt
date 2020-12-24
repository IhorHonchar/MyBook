package ua.vrgsoft.honchar.mybook.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.vrgsoft.honchar.mybook.BuildConfig

class NetworkService private constructor() {
    private val mRetrofit: Retrofit
    val api: MyBookApi
        get() = mRetrofit.create(MyBookApi::class.java)

    companion object {
        private const val BASE_URL = "https://a-book.net/api/v1/"
        private var mInstance: NetworkService? = null
        val instance: NetworkService?
            get() {
                if (mInstance == null) {
                    mInstance = NetworkService()
                }
                return mInstance
            }
    }

    init {
        val builder = OkHttpClient().newBuilder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        val client = builder.build()
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}