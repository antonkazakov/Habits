package com.green.main

import android.os.Bundle
import androidx.annotation.MenuRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.green.coreapi.mediator.AppWithFacade
import com.green.coreapi.mediator.HomeMediator
import com.green.main.di.MainComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var homeMediator: HomeMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainComponent.create((application as AppWithFacade).getFacade()).inject(this)
        setContentView(R.layout.activity_main)
        mainNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    homeMediator.startHomeScreen(
                        R.id.mainFragmentsContainer,
                        supportFragmentManager
                    )
                    true
                }
                else -> false
            }
        }

    }
}
