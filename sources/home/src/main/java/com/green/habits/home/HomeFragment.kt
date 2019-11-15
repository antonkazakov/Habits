package com.green.habits.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.green.coreapi.mediator.AppWithFacade
import com.green.habits.home.di.EagerTrigger
import com.green.habits.home.di.HomeComponent
import com.green.habits.home.view.MainHabitListAdapter
import com.green.habits.home.view.MainHabitsItemDecorator
import com.green.habits.home.viewmodel.HomeViewModel
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {

        fun newInstance() = HomeFragment()
    }

    private val habitsListAdapter = MainHabitListAdapter()
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var eagerTrigger: EagerTrigger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
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
        weekBar.setSelectedDay(viewModel.getDayOfWeek() - 1)
        initRecycler()
        viewModel.todayHabits.observe(this, Observer {
            habitsListAdapter.items.addAll(it)
            habitsListAdapter.notifyDataSetChanged()
        })
        viewModel.getHabits(1)
        fab.setOnClickListener{
            viewModel.openCreateHabitScreen(requireContext())
        }
    }

    private fun initRecycler() {
        habitsListRecycler.addItemDecoration(MainHabitsItemDecorator())
        habitsListRecycler.adapter = habitsListAdapter
        habitsListRecycler.itemAnimator = SlideInLeftAnimator()
    }
}