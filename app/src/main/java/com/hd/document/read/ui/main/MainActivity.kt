package com.hd.document.read.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hd.document.read.R
import com.hd.document.read.databinding.MainActBinding
import com.hd.document.read.extensions.toastNormal
import com.hd.document.read.ui.base.BaseActivity
import com.hd.document.read.ui.main.viewpager.ViewPagerActivity
import com.hd.document.read.ui.main.recyclerview.RecyclerViewActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<MainActBinding>() {
    companion object {
        private const val TAG: String = "LifeCycle"
    }

    private var doubleBackToExitPressedOnce = false

    override fun initView() = binding.run {

    }

    override fun initData() {

    }

    override fun initListener() {
        binding.btnAddFrA.setOnClickListener {
            addFragment(AFragment())
        }
        binding.btnAddFrB.setOnClickListener {
            addFragment(BFragment())
        }
        binding.btnRepFrA.setOnClickListener {
            replaceFragment(AFragment())
        }
        binding.btnRepFrB.setOnClickListener {
            replaceFragment(BFragment())
        }
        binding.btnGo.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
        binding.btnGoAct2.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
            return
        }

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        toastNormal(resources.getString(R.string.please_click_back_again_to_exit))
        lifecycleScope.launch {
            delay(2000)
            doubleBackToExitPressedOnce = false
        }
    }

    override fun viewBinding(): MainActBinding = MainActBinding.inflate(LayoutInflater.from(this))

    /**
     * add fragment into the container
     *
     * @param fragment Fragment
     */
    private fun addFragment(fragment: Fragment): Unit {
        supportFragmentManager.beginTransaction().apply {
            add(binding.frMain.id, fragment)
            addToBackStack(null)
            commit()
        }
    }

    /**
     * replace fragment
     *
     * @param fragment Fragment
     */
    private fun replaceFragment(fragment: Fragment): Unit {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.frMain.id, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity: onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity: onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity: onRestart")
    }

}
