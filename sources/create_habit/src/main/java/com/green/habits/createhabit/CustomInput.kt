package com.green.habits.createhabit

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.habit_name_input_layout.view.*

class CustomInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = HORIZONTAL
        View.inflate(context, R.layout.habit_name_input_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        habitIcon.setOnClickListener {

        }
    }
}