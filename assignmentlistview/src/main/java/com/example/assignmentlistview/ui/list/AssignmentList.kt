package com.example.assignmentlistview.ui.list

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.component.SamuraiListComponent
import com.example.assignmentlistview.core.entity.ViewEntity

public class AssignmentList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.samuraiAssignmentListView
) : ListView(context, attrs, defStyleAttr),
    SamuraiListComponent<AssignmentList.ItemEntity> {

    private val assignmentListAdapter = AssignmentListAdapter()

    init {
        adapter = assignmentListAdapter
    }

    override fun setup(items: List<ItemEntity>) {
        assignmentListAdapter.updateItems(items)
    }

    public data class ItemEntity(
        val imageUrl: String
    ) : ViewEntity()
}