package com.green.habits.home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.green.uicore.dip2px

class RecommendationsItemDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.set(view.dip2px(16).toInt(), view.dip2px(4).toInt(), view.dip2px(4).toInt(), view.dip2px(4).toInt())
        } else {
            outRect.set(view.dip2px(4).toInt(), view.dip2px(4).toInt(), view.dip2px(4).toInt(), view.dip2px(4).toInt())
        }
    }
}