package com.green.habits.createhabit

import android.content.Context
import android.os.*
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.number_picker_layout.view.*
import android.os.Bundle


private const val COUNTER_KEY = "counter"

class NumberPickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val vibrator: Vibrator by lazy { context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator }
    private var counter = 0

    init {
        orientation = HORIZONTAL
        inflate(context, R.layout.number_picker_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        fun updateValue(value: Int) {
            valueTextView.text = value.toString()
        }

        valueTextView.text = counter.toString()
        plusButton.setOnClickListener {
            vibrate()
            counter += 1
            updateValue(counter)
        }
        minusButton.setOnClickListener {
            vibrate()
            counter -= 1
            updateValue(counter)
        }
    }

    private fun vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, -1))
        } else {
            vibrator.vibrate(20)
        }
    }

    override fun onSaveInstanceState(): Parcelable {
        return Bundle().apply {
            putParcelable("superState", super.onSaveInstanceState())
            putInt(COUNTER_KEY, counter)
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        var actualState: Parcelable? = null
        if (state is Bundle) {
            counter = state.getInt(COUNTER_KEY)
            actualState = state.getParcelable("superState")
        }
        super.onRestoreInstanceState(actualState ?: state)
    }
}