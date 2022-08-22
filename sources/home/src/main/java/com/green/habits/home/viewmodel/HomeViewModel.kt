package com.green.habits.home.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import com.green.coreapi.database.HabitsDao
import com.green.coreapi.dto.Habit
import com.otus.create_habit_api.CreateHabitMediator
import com.green.habits.home.R
import com.green.habits.home.repository.HabitsMemoryCache
import com.green.habits.home.view.MainHabitModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel
constructor(
    private val habitsMemoryCache: HabitsMemoryCache,
    private val habitsDao: HabitsDao,
    private val createHabitMediator: CreateHabitMediator
) : ViewModel() {

    private val _todayHabits = MutableLiveData<List<Habit>>()
    val todayHabits: LiveData<List<MainHabitModel>> = Transformations.map(_todayHabits) { list ->
        listOf(
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

    /*todo здесь вычитается один день тк апи считает дни начиная с воскресенья. нужно поставить
    галочку в настройках на выбор точки отсчета дней недели
    */
    fun getDayOfWeek(): Int {
        val c = Calendar.getInstance(Locale("ru", "RU"))
        c.firstDayOfWeek = Calendar.MONDAY
        c.timeInMillis = System.currentTimeMillis()
        return c.get(Calendar.DAY_OF_WEEK) - 1
    }

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getHabits(day: Int) {
        uiScope.launch {
            _todayHabits.value = habitsMemoryCache.getHabits(day).ifEmpty {
                habitsDao.getHabits()
            }.also {
                habitsMemoryCache.saveHabit(day, it)
            }
        }
    }

    fun openCreateHabitScreen(context: Context) {
        createHabitMediator.openCreateHabitScreen(context)
    }
}

class HomeViewModelFactory @Inject constructor(
    private val habitsMemoryCache: HabitsMemoryCache,
    private val habitsDao: HabitsDao,
    private val createHabitMediator: CreateHabitMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(habitsMemoryCache, habitsDao, createHabitMediator) as T
    }
}