package com.example.assignmentlistview.ui.assignmentlistview

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.component.SamuraiListComponent
import com.example.assignmentlistview.core.entity.ViewEntity

class AssignmentList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.samuraiAssignmentListView
) : ListView(context, attrs, defStyleAttr),
    SamuraiListComponent<AssignmentList.ItemEntity> {

    private val assignmentListAdapter = AssignmentListAdapter()

    init {
        obtainStyledAttributes(attrs, defStyleAttr)
        adapter = assignmentListAdapter
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.AssignmentListView,
            defStyleAttr,
            0
        )
    }

    override fun setup(items: List<ItemEntity>) {
        assignmentListAdapter.updateItems(items)
    }

    data class ItemEntity(
        val imageUrl: String
    ) : ViewEntity()
}