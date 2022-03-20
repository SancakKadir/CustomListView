package com.example.assignmentlistview.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.adapter.DefaultItemAdapter
import com.example.assignmentlistview.ui.image.SamuraiImageView


class AssignmentListAdapter : DefaultItemAdapter<AssignmentList.ItemEntity>() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ItemViewHolder
        val item = items[position]

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_component_assignment_list, parent, false)

            viewHolder = ItemViewHolder()
            viewHolder.imageView = itemView.findViewById<View>(R.id.ivAssignment) as SamuraiImageView

            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ItemViewHolder
        }

            viewHolder.imageView.loadImage(item.imageUrl)

        return itemView
    }

    private class ItemViewHolder {
        lateinit var imageView: SamuraiImageView
    }
}