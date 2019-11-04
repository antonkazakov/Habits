package com.green.habits.createhabit


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_create_habit.*

class CreateHabitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_habit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test.setDotsNumber(2)
        Handler().postDelayed({ test.updateCounter() }, 2200)
        Handler().postDelayed({ test.updateCounter() }, 4200)

        Handler().postDelayed({ test.decCounter() }, 6200)
        Handler().postDelayed({ test.decCounter() }, 8200)
       // Handler().postDelayed({ test.decCounter() }, 3200)
    }
}
