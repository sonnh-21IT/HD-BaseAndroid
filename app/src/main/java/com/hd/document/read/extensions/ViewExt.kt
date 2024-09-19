package com.hd.document.read.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.SystemClock
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import androidx.transition.Slide
import androidx.transition.TransitionManager

/**
 * Visible an view.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * Gone an view.
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * Invisible an view.
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

private const val ONE_THOUSAND = 1000

/**
 * Check to prevent double click.
 */
fun View.addOnClick(listener: ((View) -> Unit)? = null) {
    var click: Long = 0
    setOnClickListener {
        if (SystemClock.elapsedRealtime() - click >= ONE_THOUSAND) {
            click = SystemClock.elapsedRealtime()
            listener?.invoke(it)
        }
    }
}

/**
 * Transition a [ViewGroup] from left.
 */
fun ViewGroup.slideFromLeft() {
    val enterTransition = Slide(Gravity.START)
    TransitionManager.beginDelayedTransition(this, enterTransition)
}

/**
 * Transition a [ViewGroup] from right.
 */
fun ViewGroup.slideFromRight() {
    val enterTransition = Slide(Gravity.END)
    TransitionManager.beginDelayedTransition(this, enterTransition)
}

fun ViewGroup.slideUp(duration: Long = 300) {
    visible()
    val animate = TranslateAnimation(
        0F,  // fromXDelta
        0F,  // toXDelta
        height.toFloat(),  // fromYDelta
        0F
    ) // toYDelta
    animate.duration = duration
    animate.fillAfter = true
    startAnimation(animate)
}

fun ViewGroup.slideDown(duration: Long = 300) {
    val animate = TranslateAnimation(
        0F,  // fromXDelta
        0F,  // toXDelta
        0F,  // fromYDelta
        height.toFloat()
    ) // toYDelta
    animate.duration = duration
    animate.fillAfter = true
    startAnimation(animate)
    gone()
}

fun ViewGroup.fadeIn(duration: Long = 300, completion: () -> Unit) {
    animate()
        .alpha(1.0F)
        .setDuration(duration)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                completion()
            }
        })
}

fun ViewGroup.fadeOut(duration: Long = 300, completion: () -> Unit) {
    animate()
        .alpha(0.0F)
        .setDuration(duration)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                completion()
            }
        })
}

/**
 * Rotation a [View].
 */
fun View.rotation(degree: Float) {
    val f = this.rotation
    val animator = ObjectAnimator.ofFloat(this, "rotation", f, degree)
    animator.start()
}

fun View.hideSoftKeyboard() {
    val inputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}