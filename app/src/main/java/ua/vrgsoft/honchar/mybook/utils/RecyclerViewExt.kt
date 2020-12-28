package ua.vrgsoft.honchar.mybook.utils

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator

fun RecyclerView?.offAnimation() {
    this?.itemAnimator?.let {
        if (it is SimpleItemAnimator) {
            it.supportsChangeAnimations = false
        }
    }
}