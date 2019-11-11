package com.green.habits.home.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.green.habits.home.R
import com.green.uicore.Populatable
import kotlinx.android.synthetic.main.recommendations_cell_layout.view.*

class RecommendationsCell
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), Populatable<RecommendationsHolder> {

    private val adapter = RecommendationsAdapter()

    override fun onFinishInflate() {
        super.onFinishInflate()
        val startSnapHelper = StartSnapHelper()
        startSnapHelper.attachToRecyclerView(recommendationsRecyclerView)
        recommendationsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recommendationsRecyclerView.adapter = adapter
        recommendationsRecyclerView.addItemDecoration(RecommendationsItemDecorator())
    }

    override fun populate(model: RecommendationsHolder) {
        adapter.items.addAll(model.recommendations)
    }
}

data class RecommendationsHolder(
    val recommendations: List<RecommendationModel>
) : MainListItemType {

    override fun getItemType() = R.layout.recommendations_cell_layout
}

data class RecommendationModel(
    val id: Long,
    val title: String,
    val subtitle: String,
    val imageBackgroundUrl: String,
    val imageForegroundUrl: String
)