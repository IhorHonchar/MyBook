package ua.vrgsoft.honchar.mybook.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import retrofit2.Call
import retrofit2.Response
import ua.vrgsoft.honchar.mybook.R
import ua.vrgsoft.honchar.mybook.model.AuthorsResponse
import ua.vrgsoft.honchar.mybook.model.Books
import ua.vrgsoft.honchar.mybook.model.Book
import ua.vrgsoft.honchar.mybook.model.TopBooksResponse
import ua.vrgsoft.honchar.mybook.network.NetworkService

class MainActivity : AppCompatActivity() {

    val TAG : String = MainActivity::class.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
