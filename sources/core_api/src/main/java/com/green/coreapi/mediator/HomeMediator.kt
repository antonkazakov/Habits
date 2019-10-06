package com.green.coreapi.mediator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface HomeMediator {

    fun startHomeScreen(@IdRes containerId: Int, fragmentManager: FragmentManager)
}