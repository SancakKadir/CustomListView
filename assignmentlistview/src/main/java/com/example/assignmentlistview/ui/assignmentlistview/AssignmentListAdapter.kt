package com.example.assignmentlistview.ui.assignmentlistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.adapter.DefaultItemAdapter


class AssignmentListAdapter : DefaultItemAdapter<AssignmentList.ItemEntity>() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ItemViewHolder
        val item = items[position]

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_component_assignment_list, parent, false)

            viewHolder = ItemViewHolder()
            viewHolder.imageView = itemView.findViewById<View>(R.id.ivAssignment) as ImageView

            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ItemViewHolder
        }

        Glide.with(viewHolder.imageView.context)
            .load(item.imageUrl)
            .placeholder(R.drawable.ic_place_holder)
            .into(viewHolder.imageView)


        return itemView
    }

    private class ItemViewHolder {
        lateinit var imageView: ImageView
    }
}