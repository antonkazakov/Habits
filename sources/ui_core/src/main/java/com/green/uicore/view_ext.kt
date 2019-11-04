package com.green.uicore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes

@Suppress("UNCHECKED_CAST")
fun <T : View> ViewGroup.inflate(@LayoutRes res: Int): T {
    return LayoutInflater.from(this.context).inflate(res, this, false) as T
}

fun TextView.showOrHide(value: String?) {
    if (value.isNullOrBlank()) visibility = View.GONE else {
        visibility = View.VISIBLE
        text = value
    }
}

fun View.showOrHide(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}

fun View.dip2px(dip: Int): Float = dip * resources.displayMetrics.density

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}