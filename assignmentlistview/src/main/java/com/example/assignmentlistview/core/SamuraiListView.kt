package com.example.assignmentlistview.core

import com.example.assignmentlistview.core.entity.ViewEntity

interface SamuraiListView<I : ViewEntity> {

    /*
     * Use for setup component
     */
    fun setup(items: List<I>?)
}