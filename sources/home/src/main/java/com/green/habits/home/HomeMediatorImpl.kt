package com.green.habits.home

import androidx.fragment.app.FragmentManager
import com.green.coreapi.mediator.HomeMediator
import javax.inject.Inject

class HomeMediatorImpl
@Inject constructor() : HomeMediator {

    override fun startHomeScreen(containerId: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(containerId, HomeFragment.newInstance())
            .commit()
    }
}