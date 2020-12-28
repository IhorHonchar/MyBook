package ua.vrgsoft.honchar.mybook.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestAdapter(val resId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(resId, parent, false)
        return Holder(v)
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    class Holder(v: View) : RecyclerView.ViewHolder(v)
}