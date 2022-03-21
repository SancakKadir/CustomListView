package com.example.assignmentlistview.core.entity

import android.os.Bundle

/*
 *  Parent class for View Entities
 */
public abstract class ViewEntity {
    /*
     * Attributes bundle
     * Used for storing some internal attributes of view entity
     */
    public val attributes by lazy {
        Bundle()
    }
}