package com.green.habits.createhabit

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.suggested_habit_item_layout.view.*

class SuggestedHabitItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun populate(suggestedHabitModel: SuggestedHabitModel) {
        suggestedHabitTitle.text = suggestedHabitModel.name
    }
}