package com.example.assignmentlistview.ui.assignmentlistview

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView
import com.example.assignmentlistview.R
import com.example.assignmentlistview.core.SamuraiListView
import com.example.assignmentlistview.core.entity.ViewEntity

class AssignmentListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.samuraiAssignmentListView
) : ListView(context, attrs, defStyleAttr), SamuraiListView<AssignmentListView.ItemEntity> {

    init {
        obtainStyledAttributes(attrs, defStyleAttr)
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.AssignmentListView,
            defStyleAttr,
            0
        )
    }

    override fun setup(items: List<ItemEntity>?) {
        TODO("Not yet implemented")
    }

    data class ItemEntity(
        val imageUrl: String
    ) : ViewEntity()
}