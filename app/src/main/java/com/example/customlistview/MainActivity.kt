package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignmentlistview.ui.assignmentlistview.AssignmentList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<AssignmentList>(R.id.assignment)

        list.setup(
            listOf(
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-500kb.png"),
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-1mb.png"),
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-1_5mb.png"),
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-2mb.png"),
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-3mb.png"),
                AssignmentList.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-5mb.png"),
            )
        )
    }
}