package com.example.assignmentlistview.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.adapter.DefaultItemAdapter
import com.example.assignmentlistview.network.LoggingInterceptor
import com.example.assignmentlistview.ui.image.SamuraiImageView
import okhttp3.*
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


internal class AssignmentListAdapter : DefaultItemAdapter<AssignmentList.ItemEntity>() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ItemViewHolder
        val item = items[position]

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_component_assignment_list, parent, false)

            viewHolder = ItemViewHolder()
            viewHolder.imageView =
                itemView.findViewById<View>(R.id.ivAssignment) as SamuraiImageView

            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ItemViewHolder
        }

        bind(viewHolder, item)


        return itemView
    }

    private fun bind(viewHolder: ItemViewHolder, item: AssignmentList.ItemEntity) {
        viewHolder.imageView.loadImage(item.imageUrl)
        viewHolder.imageView.onImageLoadingTimeChange = {
            item.apply {
                attributes.putLong(IMAGE_LOAD_TIME, it)
            }
            if (items.all { it.attributes.get(IMAGE_LOAD_TIME) != null }) {
                trackImageLoadingTimes()
            }
        }
    }

    private class ItemViewHolder {
        lateinit var imageView: SamuraiImageView
    }

    private fun trackImageLoadingTimes() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(LoggingInterceptor())
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()

        val formBody = FormBody
            .Builder()

        items.forEach { item ->
            val loadTime = item.attributes.getLong(IMAGE_LOAD_TIME).toString()
            formBody.add(item.imageUrl, loadTime)
        }

        val requestBody: RequestBody = formBody
            .build()

        val request: Request = Request.Builder()
            .url("https://httpbin.org/")
            .post(requestBody)
            .build()


        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        executor.execute {
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //no-op
                }
                override fun onResponse(call: Call, response: Response) {
                    //no-op
                }
            })
        }

    }

    companion object {
        const val IMAGE_LOAD_TIME = "image_load_time"
    }
}