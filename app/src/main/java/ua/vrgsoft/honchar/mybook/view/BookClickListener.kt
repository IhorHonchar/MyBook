package ua.vrgsoft.honchar.mybook.view

import ua.vrgsoft.honchar.mybook.model.Book

interface BookClickListener {
    fun onClick(id: Long)
    fun onClickByStar(book: Book)
    fun onLongClick(book: Book)
}