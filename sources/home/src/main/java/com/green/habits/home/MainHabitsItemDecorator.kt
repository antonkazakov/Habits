package com.green.habits.home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainHabitsItemDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.set(10, 10, 0, 10)
        } else {
            outRect.set(10, 10, 10, 10)
        }
    }
}