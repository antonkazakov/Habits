package com.green.habits.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder

class MainHabitListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<MainListItemType> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.main_habit_cell_layout -> MainHabitsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.main_habit_cell_layout,
                    parent,
                    false
                ) as MainHabitCell
            )
            R.layout.recommendations_cell_layout -> RecommendationsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recommendations_cell_layout,
                    parent,
                    false
                ) as RecommendationsCell
            )
            else -> throw IllegalArgumentException("Wrong type")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.main_habit_cell_layout -> (holder as MainHabitsViewHolder).populate(items[position])
            R.layout.recommendations_cell_layout -> (holder as RecommendationsViewHolder).populate(items[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getItemType()
    }

    class MainHabitsViewHolder(
        private val item: MainHabitCell
    ) : RecyclerView.ViewHolder(item), AnimateViewHolder {

        override fun preAnimateAddImpl(holder: RecyclerView.ViewHolder) {
            holder.itemView.translationX = -holder.itemView.rootView.width.toFloat()
        }

        override fun preAnimateRemoveImpl(holder: RecyclerView.ViewHolder?) {
        }

        override fun animateAddImpl(holder: RecyclerView.ViewHolder, listener: ViewPropertyAnimatorListener?) {
            holder.itemView
                .animate()
                .translationX(0F)
                .setDuration(120)
                .setInterpolator(LinearInterpolator())
                .start()
        }

        override fun animateRemoveImpl(holder: RecyclerView.ViewHolder, listener: ViewPropertyAnimatorListener?) {
            holder.itemView
                .animate()
                .translationX(-holder.itemView.rootView.width.toFloat())
                .setDuration(120)
                .setInterpolator(LinearInterpolator())
                .start()
        }

        fun populate(model: MainListItemType) {
            item.populate(model as MainHabitModel)
        }
    }

    class RecommendationsViewHolder(
        private val item: RecommendationsCell
    ) : RecyclerView.ViewHolder(item) {

        fun populate(model: MainListItemType) {
            item.populate(model as RecommendationsHolder)
        }
    }
}