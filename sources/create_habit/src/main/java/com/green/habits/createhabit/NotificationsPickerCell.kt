package com.green.habits.createhabit

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class NotificationsPickerCell @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.repeats_number_picker_layout, this)
    }
}