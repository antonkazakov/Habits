package com.green.habits.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*

class HomeViewModel
@Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    /*todo здесь вычитается один день тк апи считает дни начиная с воскресенья. нужно поставить
    галочку в настройках на выбор точки отсчета дней недели
    */
    fun getDayOfWeek(): Int {
        val c = Calendar.getInstance(Locale("ru", "RU"))
        c.firstDayOfWeek = Calendar.MONDAY
        c.timeInMillis = System.currentTimeMillis()
        return c.get(Calendar.DAY_OF_WEEK) - 1
    }

    fun getTodayHabits(): List<MainHabitModel> {
        return listOf(
            MainHabitModel(
                1L, "Eat some vegetables", R.drawable.emoji_leafy, 3, 4, false
            ),
            MainHabitModel(
                1L, "Go for a walk with Doggie", R.drawable.emoji_dog_face, 3, 4, false
            ),
            MainHabitModel(
                1L, "Fell in love ", R.drawable.emoji_hearts_eyes, 3, 4, false
            )
        )
    }

    fun getAllHabits(): List<MainHabitModel> {
        return listOf(
            MainHabitModel(
                1L, "Eat some vegetables", R.drawable.emoji_leafy, 3, 4, false
            ),
            MainHabitModel(
                1L, "Go for a walk with Doggie", R.drawable.emoji_dog_face, 3, 4, false
            ),
            MainHabitModel(
                1L, "Fell in love ", R.drawable.emoji_hearts_eyes, 3, 4, false
            ),
            MainHabitModel(
                1L, "Go for a walk with Doggie", R.drawable.emoji_dog_face, 3, 4, false
            ),
            MainHabitModel(
                1L, "Go for a walk with Doggie", R.drawable.emoji_dog_face, 3, 4, false
            ),
            MainHabitModel(
                1L, "Go for a walk with Doggie", R.drawable.emoji_dog_face, 3, 4, false
            )
        )
    }
}