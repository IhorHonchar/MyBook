package ua.vrgsoft.honchar.mybook.view.ui.books

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import kotlinx.android.synthetic.main.list_item_book_series_horizontal.view.*
import kotlinx.android.synthetic.main.list_item_book_series_horizontal.view.ivBookImage
import kotlinx.android.synthetic.main.list_item_book_series_horizontal.view.tvBookAuthor
import kotlinx.android.synthetic.main.list_item_book_series_horizontal.view.tvBookTitle
import kotlinx.android.synthetic.main.view_book.view.*
import ua.vrgsoft.honchar.mybook.R

@BindingMethods(
    BindingMethod(
        type = BookView::class,
        attribute = "app:bvStarClickListener",
        method = "setBvStarClickListener"
    )
)
class BookView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(
    context,
    attrs,
    defStyleAttr
) {
    var bvTitle: String? = ""
        set(value) {
            field = value ?: ""
            tvBookTitle?.text = field
        }
    var bvAuthorName: String? = ""
        set(value) {
            field = value ?: ""
            tvBookAuthor?.text = field
        }
    var bvReaderName: String? = ""
        set(value) {
            field = value ?: ""
            tvReaderName?.text = field
        }
    var bvTimeInMillis: Long? = 0
        set(value) {
            field = value ?: 0L
            tvTime?.text = field!!.toTimeString()
        }
    var bvState: Int? = 1
        set(value) {
            field = value ?: 1
            redrawState()
        }
    var bvProgress: Float? = 0f
        set(value) {
            field = value ?: 0f
            tvBookReadProgress?.text = "${field?.toInt()}%"
        }
    var bvFavorite: Boolean = false
        set(value) {
            field = value
            if (field) {
                ivStar?.setImageResource(R.drawable.ic_favorite_red)
            } else {
                ivStar?.setImageResource(R.drawable.ic_favorite_gray)
            }
        }
    var bvSelected: Boolean = false
        set(value) {
            field = value
            if (field) {
                ivSelectedBackground?.visibility = View.VISIBLE
                ivCheckedIcon?.visibility = View.VISIBLE
            } else {
                ivSelectedBackground?.visibility = View.GONE
                ivCheckedIcon?.visibility = View.GONE
            }
        }

    var bvReadingNow: Int = 0
        set(value) {
            field = value
            reading_now?.visibility = View.VISIBLE
            tv_reading_count?.text = field.toString()
        }

    private fun Long.toTimeString(): String {
        return ua.vrgsoft.honchar.mybook.utils.TimeUtils.millisecondsToTime(this) //SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(this@toTimeString)
    }

    fun getImage() = ivBookImage!!
    fun getBlurredImage() = ivBookSurface!!

    override fun onFinishInflate() {
        super.onFinishInflate()

        tvBookTitle.text = bvTitle
        tvBookAuthor.text = bvAuthorName
        tvReaderName.text = bvReaderName
        tvTime.text = bvTimeInMillis!!.toTimeString()
        tvBookReadProgress.text = "${bvProgress?.toInt()}%"

        ivStar.setOnClickListener {
            bvFavorite = !bvFavorite

            val stringId: Int = when (bvFavorite) {
                true -> R.string.book_added_to_favorite
                else -> R.string.book_removed_from_favorite
            }

            Toast.makeText(context, context.getString(stringId), Toast.LENGTH_SHORT).show()

            bvStarClickListener?.onClick(bvFavorite)
        }

        redrawState()
    }

    var bvStarClickListener: StarClickListener? = null

    private fun redrawState() {
        when (bvState) {
            1 -> {
                ivProgressCircle?.visibility = View.GONE
                tvBookReadProgress?.visibility = View.GONE

                btnBookLoadMore?.visibility = View.GONE
                buttonText?.visibility = View.GONE
                ivBookSurface?.visibility = View.GONE
            }
            2 -> {
                ivProgressCircle?.visibility = View.VISIBLE
                tvBookReadProgress?.visibility = View.VISIBLE

                btnBookLoadMore?.visibility = View.GONE
                buttonText?.visibility = View.GONE
                ivBookSurface?.visibility = View.GONE
            }
            else -> {
                ivProgressCircle?.visibility = View.GONE
                tvBookReadProgress?.visibility = View.GONE

                btnBookLoadMore?.visibility = View.VISIBLE
                buttonText?.visibility = View.VISIBLE
                ivBookSurface?.visibility = View.VISIBLE
            }
        }
    }

    init {
        try {
            val arr = context?.obtainStyledAttributes(attrs, R.styleable.BookView)

            bvTitle = arr?.getString(R.styleable.BookView_bvTitle) ?: ""
            bvAuthorName = arr?.getString(R.styleable.BookView_bvAuthorName) ?: ""
            bvReaderName = arr?.getString(R.styleable.BookView_bvReaderName) ?: ""
            bvTimeInMillis = arr?.getInt(R.styleable.BookView_bvTimeInMillis, 0)?.toLong() ?: 0L
            bvState = arr?.getInt(R.styleable.BookView_bvState, 1) ?: 1
            bvProgress = arr?.getFloat(R.styleable.BookView_bvProgress, 0f) ?: 0f
            bvFavorite = arr?.getBoolean(R.styleable.BookView_bvFavorite, false) ?: false
            bvSelected = arr?.getBoolean(R.styleable.BookView_bvSelected, false) ?: false

            arr?.recycle()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        inflate(context, R.layout.view_book, this)
    }
}