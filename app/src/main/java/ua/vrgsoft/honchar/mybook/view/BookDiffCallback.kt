package ua.vrgsoft.honchar.mybook.view

import androidx.recyclerview.widget.DiffUtil
import ua.vrgsoft.honchar.mybook.model.Book

class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}