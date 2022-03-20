package com.example.assignmentlistview.core.adapter

import com.example.assignmentlistview.core.entity.ViewEntity

interface ItemAdapter<T : ViewEntity> {

    var items: List<T>

    fun updateItems(items: List<T>)
}