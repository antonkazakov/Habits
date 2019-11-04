package com.green.habits.home

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.green.uicore.Populatable
import kotlinx.android.synthetic.main.recommendation_cell_layout.view.*

class RecommendationSingleCell @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr), Populatable<RecommendationModel> {

    override fun populate(model: RecommendationModel) {
        textView.text = model.title
    }
}