package ua.vrgsoft.honchar.mybook.view.ui.books

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.vrgsoft.honchar.mybook.model.Book
import ua.vrgsoft.honchar.mybook.view.BaseAdapter
import ua.vrgsoft.honchar.mybook.view.BookClickListener
import ua.vrgsoft.honchar.mybook.view.BookDiffCallback

class PopularBooksAdapter(private val listener: BookClickListener) : BaseAdapter<Book>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}