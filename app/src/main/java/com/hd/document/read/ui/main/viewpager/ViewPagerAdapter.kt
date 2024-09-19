package com.hd.document.read.ui.main.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragmentCreator: Map<Int, () -> Fragment> = mapOf(
        FIRST to { FirstFragment() },
        SECOND to { SecondFragment() },
        THIRD to { ThirdFragment() },
    )

    override fun getItemCount(): Int = fragmentCreator.size

    override fun createFragment(position: Int): Fragment =
        fragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()

    companion object {
        private const val FIRST = 0
        private const val SECOND = 1
        private const val THIRD = 2
    }
}