package com.green.habits.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecommendationsAdapter : RecyclerView.Adapter<RecommendationsAdapter.RecommendationViewHolder>() {

    var items: MutableList<RecommendationModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendation_cell_layout, parent, false)
        return RecommendationViewHolder(view as RecommendationSingleCell)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.populate(items[position])
    }

    class RecommendationViewHolder(
        private val item: RecommendationSingleCell
    ) : RecyclerView.ViewHolder(item) {

        fun populate(model: RecommendationModel) {
            item.populate(model)
        }
    }
}

