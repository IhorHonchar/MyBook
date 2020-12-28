package ua.vrgsoft.honchar.mybook.view

import android.content.res.Resources
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecorator(private val resources: Resources) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.right = dpToPx(8f)
    }

    private fun dpToPx(dip: Float): Int {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                resources.displayMetrics
        ).toInt()
    }
}