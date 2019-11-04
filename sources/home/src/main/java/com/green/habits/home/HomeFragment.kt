package com.green.habits.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.green.coreapi.mediator.AppWithFacade
import com.green.coreapi.mediator.CreateHabitMediator
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {

        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var createHabitMediator: CreateHabitMediator

    private val habitsListAdapter = MainHabitListAdapter()
    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        habitsListRecycler.addItemDecoration(MainHabitsItemDecorator())
        habitsListRecycler.adapter = habitsListAdapter
        habitsListRecycler.itemAnimator = SlideInLeftAnimator()

        val items = viewModel!!.getTodayHabits()
        val recs = mutableListOf(
            RecommendationsHolder(
                listOf(
                    RecommendationModel(1L, "Rate our app", "", "", ""),
                    RecommendationModel(1L, "Rate our app", "", "", ""),
                    RecommendationModel(1L, "Rate our app", "", "", "")
                )
            )
        )
        habitsListAdapter.items.addAll(recs)
        habitsListAdapter.items.addAll(items)
        habitsListAdapter.notifyDataSetChanged()

        fab.setOnClickListener {
            habitsListAdapter.notifyItemRangeRemoved(1, habitsListAdapter.items.size - 1)
        }
    }
}