package com.hd.document.read.ui.main.viewpager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import com.hd.document.read.databinding.ViewpagerActBinding
import com.hd.document.read.ui.base.BaseActivity

class ViewPagerActivity : BaseActivity<ViewpagerActBinding>() {
    companion object {
        private const val TAG: String = "LifeCycle"
    }

    private val viewPagerAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ViewPagerAdapter(this)
    }

    override fun initView() = binding.run {
        vpMain.run {
            adapter = viewPagerAdapter
            offscreenPageLimit = 2
            isUserInputEnabled = true
            orientation = ViewPager2.ORIENTATION_VERTICAL
        }
    }

    override fun initData() {

    }

    override fun initListener() {

    }

    override fun viewBinding(): ViewpagerActBinding =
        ViewpagerActBinding.inflate(LayoutInflater.from(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SecondActivity: onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "SecondActivity: onRestart")
    }
}