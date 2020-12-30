package ua.vrgsoft.honchar.mybook.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import ua.vrgsoft.honchar.mybook.model.Books
import ua.vrgsoft.honchar.mybook.network.NetworkService

class MyBooksRepository {
    private val network = NetworkService.instance?.api
    val data = MutableLiveData<Books>()

    fun getPopularBooks(limit:Int, offset:Int) : MutableLiveData<Books> {
        network?.getPopularBooks(limit, offset)?.enqueue(object : retrofit2.Callback<Books> {
            override fun onResponse(call: Call<Books>, response: Response<Books>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<Books>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })
        return data
    }



    companion object{
        val TAG : String = MyBooksRepository::class.java.simpleName.toString()
    }
}