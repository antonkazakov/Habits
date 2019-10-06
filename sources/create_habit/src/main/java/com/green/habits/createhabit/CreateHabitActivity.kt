package com.green.habits.createhabit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CreateHabitActivity : AppCompatActivity() {

    companion object {

        fun startCreateHabitActivity(context: Context) {
            context.startActivity(Intent(context, CreateHabitActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)
    }
}
