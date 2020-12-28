package ua.vrgsoft.honchar.mybook.view

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
        PagedListAdapter<T, RecyclerView.ViewHolder>(diffCallback)