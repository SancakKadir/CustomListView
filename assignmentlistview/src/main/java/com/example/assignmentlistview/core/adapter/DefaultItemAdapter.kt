package com.example.assignmentlistview.core.adapter

import android.widget.BaseAdapter
import com.example.assignmentlistview.core.entity.ViewEntity

abstract class DefaultItemAdapter<T : ViewEntity>() : BaseAdapter(), ItemAdapter<T> {

    override var items: List<T> = listOf()

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun updateItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }
}