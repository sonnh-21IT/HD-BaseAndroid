package com.hd.document.read.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hd.document.read.databinding.HomeFragBinding
import com.hd.document.read.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeFragBinding>() {
    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {

    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): HomeFragBinding =
        HomeFragBinding.inflate(inflater)

    private val TAG : String = "LifeCycle"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"HomeFragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"HomeFragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG,"HomeFragment: onCreateView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"HomeFragment: onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"HomeFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"HomeFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"HomeFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"HomeFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"HomeFragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"HomeFragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"HomeFragment: onDetach")
    }

}