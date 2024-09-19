package com.hd.document.read.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hd.document.read.ui.main.home.HomeFragment
import com.hd.document.read.ui.main.myfiles.MyFilesFragment
import com.hd.document.read.ui.main.tools.ToolsFragment

class MainPagerAdapter(
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        HOME to { HomeFragment() },
        TOOLS to { ToolsFragment() },
        MY_FILES to { MyFilesFragment() }
    )

    override fun getItemCount() = fragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    companion object {
        private const val HOME = 0
        private const val TOOLS = 1
        private const val MY_FILES = 2
        private const val MORE = 3
    }
}
