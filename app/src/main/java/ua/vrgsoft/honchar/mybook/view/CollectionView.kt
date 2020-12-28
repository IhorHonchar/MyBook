package ua.vrgsoft.honchar.mybook.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.view_collection.view.*
import ua.vrgsoft.honchar.mybook.R
import ua.vrgsoft.honchar.mybook.utils.offAnimation

@BindingMethods(
        BindingMethod(
                type = CollectionView::class,
                attribute = "app:cvButtonClickListener",
                method = "setCvButtonClickListener"
        ),
        BindingMethod(
                type = CollectionView::class,
                attribute = "app:cvListAdapter",
                method = "setCvListAdapter"
        )
)
class CollectionView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(
        context,
        attrs,
        defStyleAttr
) {
    var cvTitle: String = ""
    var cvButtonText: String = ""

    var cvButtonClickListener: OnButtonClickListener? = null

    var cvListAdapter: BaseAdapter<*>? = null
        set(value) {
            field = value
            list.adapter = field
        }

    var cvListType: Int = 1
    var cvDirection: Int = 1
    var cvListItem: Int = R.layout.list_item_collection_item

    init {
        try {
            val arr = context?.obtainStyledAttributes(attrs, R.styleable.CollectionView)

            cvTitle = arr?.getString(R.styleable.CollectionView_cvTitle) ?: ""
            cvButtonText = arr?.getString(R.styleable.CollectionView_cvButtonText) ?: ""
            cvListType = arr?.getInt(R.styleable.CollectionView_cvListType, 1)
            cvDirection = arr?.getInt(R.styleable.CollectionView_cvDirection, 1)
            cvListItem = arr?.getResourceId(
                    R.styleable.CollectionView_cvListItem,
                    R.layout.list_item_collection_item
            )

            arr?.recycle()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        inflate(context, R.layout.view_collection, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        title.text = cvTitle
        showAllLabel.text = cvButtonText

        showAllContainer.setOnClickListener {
            cvButtonClickListener?.onButtonClick()
        }

        list.layoutManager = when (cvListType) {
            1 -> when (cvDirection) {
                1 -> LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                else -> LinearLayoutManager(context)
            }
            else -> GridLayoutManager(context, 2)
        }

        list.addItemDecoration(MarginItemDecorator(resources))
        list.offAnimation()
        list.adapter = TestAdapter(cvListItem)
    }
}