package com.example.assignmentlistview.ui.image

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.assignmentlistview.R
import java.lang.Exception

class SamuraiImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.samuraiImageView
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val glide = Glide.with(context)

    private val cacheString = DiskCacheStrategy.AUTOMATIC

    init {
        obtainStyledAttributes(attrs, defStyleAttr)
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SamuraiImageView,
            defStyleAttr,
            0
        )

        try {
            // no-op
        } catch (e: Exception) {
            // ignored
        } finally {
            typedArray.recycle()
        }
    }

    fun loadImage(uri: String?) {
        glide.load(uri).diskCacheStrategy(cacheString).into(this)
    }
}