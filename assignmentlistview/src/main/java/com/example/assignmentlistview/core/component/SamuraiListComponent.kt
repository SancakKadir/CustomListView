package com.example.assignmentlistview.core.component

import com.example.assignmentlistview.core.entity.ViewEntity

internal interface SamuraiListComponent<T : ViewEntity> {

    /*
     * Use for setup component
     */
    fun setup(items: List<T>)
}