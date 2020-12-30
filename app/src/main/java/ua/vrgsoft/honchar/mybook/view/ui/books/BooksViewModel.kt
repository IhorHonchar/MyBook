package ua.vrgsoft.honchar.mybook.view.ui.books

import androidx.lifecycle.ViewModel
import ua.vrgsoft.honchar.mybook.model.repository.MyBooksRepository

class BooksViewModel : ViewModel() {
    val repository : MyBooksRepository = MyBooksRepository()

}