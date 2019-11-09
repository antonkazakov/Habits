package com.green.uicore

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent

class WeekHeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FlexboxLayout(context, attrs, defStyleAttr) {

    var dayClickAction: ((day: Int) -> Unit)? = null

    private val daysButtons = arrayOf(
        R.id.buttonMonday,
        R.id.buttonTuesday,
        R.id.buttonWednesday,
        R.id.buttonThursday,
        R.id.buttonFriday,
        R.id.buttonSaturday,
        R.id.buttonSunday
    )

    private val days = resources.getStringArray(R.array.days)

    private var lastSelected: Button? = null

    init {
        setPadding(
            dip2px(8).toInt(),
            dip2px(16).toInt(),
            dip2px(8).toInt(),
            dip2px(16).toInt()
        )
        justifyContent = JustifyContent.SPACE_AROUND
        inflate(context, R.layout.week_header_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        daysButtons.forEachIndexed { index, id ->
            val button = findViewById<Button>(id)
            button.text = days[index]
            button?.setTextColor(ContextCompat.getColorStateList(context, R.color.week_header_text_state_list))
            button.setOnClickListener { view ->
                lastSelected?.isSelected = false
                view.isSelected = true
                lastSelected = view as Button
                dayClickAction?.invoke(index)
            }
        }
    }

    fun setSelectedDay(day: Int) {
        daysButtons.forEachIndexed { index, id ->
            val button = findViewById<Button>(id)
            if (index == day) {
                button.isSelected = true
                lastSelected = button
            } else {
                button.isSelected = false
            }
        }
    }
}