package com.green.uicore

import android.animation.Animator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import androidx.core.content.ContextCompat
import kotlin.math.min

private const val DEFAULT_RADIUS_DP = 5
private const val DOT_MARGIN = 8
private const val RADIUS_ANIMATION_PROPERTY = "radius"

class DotIndicatorView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {

    private val defaultPaint = Paint()
    private val selectedPaint = Paint()

    private var firstDotX = 0F
    private var firstDotY = 0F
    private var checkedDotY = 0F

    private var inputtedCounter = -1
    private val diameterWithMargin = dip2px(DOT_MARGIN) + dip2px(DEFAULT_RADIUS_DP) * 2

    private var radius = 0
    private var numberOfDots = 4
    private var afterUncheck = false
    private var afterCheck = false

    private var propertyRotate = PropertyValuesHolder.ofInt(RADIUS_ANIMATION_PROPERTY, 0, DEFAULT_RADIUS_DP)
    private var propertyUncheck = PropertyValuesHolder.ofInt(RADIUS_ANIMATION_PROPERTY, DEFAULT_RADIUS_DP, 0)

    init {
        defaultPaint.apply {
            style = Paint.Style.FILL
            color = ContextCompat.getColor(context, R.color.test)
            isAntiAlias = true
        }
        selectedPaint.apply {
            style = Paint.Style.FILL
            color = ContextCompat.getColor(context, R.color.primaryColor)
            isAntiAlias = true
        }
        firstDotX = paddingLeft + dip2px(DEFAULT_RADIUS_DP)
        firstDotY = paddingTop + dip2px(DEFAULT_RADIUS_DP)
        checkedDotY = paddingTop + dip2px(DEFAULT_RADIUS_DP)
    }

    fun setDotsNumber(number: Int) {
        numberOfDots = number
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        fun draw(x: Float, paint: Paint) {
            canvas.drawCircle(x, firstDotY, dip2px(DEFAULT_RADIUS_DP), paint)
        }

        for (i in 0..numberOfDots) {
            when {
                inputtedCounter > i -> {
                    draw(firstDotX + i * diameterWithMargin, selectedPaint)
                }
                inputtedCounter < i -> {
                    draw(firstDotX + i * diameterWithMargin, defaultPaint)
                    if (afterUncheck && i - inputtedCounter == 1) {
                        canvas.drawCircle(firstDotX + i * diameterWithMargin, firstDotY, dip2px(radius), selectedPaint)
                    }
                }
                inputtedCounter == i -> {
                    if (afterCheck) {
                        draw(firstDotX + i * diameterWithMargin, defaultPaint)
                        canvas.drawCircle(firstDotX + i * diameterWithMargin, firstDotY, dip2px(radius), selectedPaint)
                    } else {
                        draw(firstDotX + i * diameterWithMargin, selectedPaint)
                    }
                }
            }
        }
    }

    fun updateCounter() {
        inputtedCounter++
        afterCheck = true
        startCheckAnimation()
    }

    fun decCounter() {
        inputtedCounter--
        afterUncheck = true
        startUncheckAnimation()
    }

    private fun startCheckAnimation() {
        ValueAnimator().apply {
            setValues(propertyRotate)
            duration = 100
            addUpdateListener { animation ->
                radius = animation.getAnimatedValue(RADIUS_ANIMATION_PROPERTY) as Int
                invalidate()
            }
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    afterCheck = false
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }.start()
    }

    private fun startUncheckAnimation() {
        ValueAnimator().apply {
            setValues(propertyUncheck)
            duration = 100
            addUpdateListener { animation ->
                radius = animation.getAnimatedValue(RADIUS_ANIMATION_PROPERTY) as Int
                invalidate()
            }
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    afterUncheck = false
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec))
    }

    private fun measureWidth(measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result =
                (paddingLeft + paddingRight + numberOfDots * 2 * dip2px(DEFAULT_RADIUS_DP) + (numberOfDots - 1) * dip2px(DOT_MARGIN)).toInt()
            if (specMode == MeasureSpec.AT_MOST) {
                result = min(result, specSize)
            }
        }
        return result
    }

    private fun measureHeight(measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = (paddingBottom + paddingTop + 2 * dip2px(DEFAULT_RADIUS_DP)).toInt()
            if (specMode == MeasureSpec.AT_MOST) {
                result = min(result, specSize)
            }
        }
        return result
    }
}