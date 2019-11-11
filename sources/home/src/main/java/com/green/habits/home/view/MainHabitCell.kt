package com.green.habits.home.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.annotation.DrawableRes
import com.green.habits.home.R
import com.green.uicore.Populatable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_habit_cell_layout.view.*

class MainHabitCell
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), Populatable<MainHabitModel> {

    override fun populate(model: MainHabitModel) {
        titleView.text = model.title
        repeatsIndicatorView.setDotsNumber(4)
        Picasso.get().load(model.icon).into(iconView)
        setOnClickListener { repeatsIndicatorView.updateCounter() }
    }
}

data class MainHabitModel(
    val id: Long,
    val title: String,
    @DrawableRes val icon: Int,
    val totalRepeatsNumber: Int,
    val doneRepeatsNumber: Int,
    val isCompleted: Boolean,
    val days: List<Int> = emptyList()
) : MainListItemType {

    override fun getItemType() = R.layout.main_habit_cell_layout
}