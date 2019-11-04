package com.green.uicore

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent
import kotlin.math.abs
import kotlin.math.min

class WeekHeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FlexboxLayout(context, attrs, defStyleAttr) {

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

    init {
        setPadding(dip2px(8).toInt(), dip2px(16).toInt(), dip2px(8).toInt(), dip2px(16).toInt())
        justifyContent = JustifyContent.SPACE_AROUND
        inflate(context, R.layout.week_header_layout, this)
    }

    var lastSelected: Button? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        daysButtons.forEachIndexed { index, id ->
            val button = findViewById<Button>(id)
            button.text = days[index]
            button?.setTextColor(ContextCompat.getColorStateList(context, R.color.week_header_text_state_list))
            button.setOnClickListener {
                lastSelected?.isSelected = false
                it.isSelected = true
                lastSelected = it as Button
            }
        }
    }
}