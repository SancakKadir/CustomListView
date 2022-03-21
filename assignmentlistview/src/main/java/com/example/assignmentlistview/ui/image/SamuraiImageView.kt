package com.example.assignmentlistview.ui.image

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.example.assignmentlistview.R
import java.lang.Exception

class SamuraiImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.samuraiImageView
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val glide = Glide.with(context)

    private val cacheString = DiskCacheStrategy.AUTOMATIC

    private var _imageLoadTime: Long = INVALID_TIME

    private var imageRequestTime: Long = INVALID_TIME

    private var imageResource: String? = null

    var imageLoadingTime: Long
        get() = _imageLoadTime
        set(value) {
            _imageLoadTime = value

            logImageLoadingTime()
        }

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
            //no-op
        } catch (e: Exception) {
            // ignored
        } finally {
            typedArray.recycle()
        }
    }

    fun loadImage(uri: String?) {
        imageRequestTime = System.currentTimeMillis()
        imageResource = uri

        glide
            .load(uri)
            .listener(object : com.bumptech.glide.request.RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoadingTime = INVALID_TIME
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    val displayTime = System.currentTimeMillis()
                    if (dataSource == DataSource.REMOTE || dataSource == DataSource.DATA_DISK_CACHE) {
                        imageLoadingTime = displayTime - imageRequestTime
                    }
                    return false
                }

            })
            .diskCacheStrategy(cacheString)
            .into(this)
    }

    private fun logImageLoadingTime() {
        if (_imageLoadTime == INVALID_TIME) {
            Log.d(LOG_IMAGE_LOADING_TIME, " load is failed for $imageResource $imageRequestTime")
        } else {
            Log.d(
                LOG_IMAGE_LOADING_TIME,
                "$imageResource's loading time :  $imageLoadingTime ms"
            )
        }
    }

    companion object {
        const val INVALID_TIME: Long = -1
        const val LOG_IMAGE_LOADING_TIME = "ImageLoadingTime"
    }
}