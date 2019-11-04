package com.green.habits.home

import androidx.annotation.LayoutRes

interface MainListItemType {

    @LayoutRes
    fun getItemType(): Int
}