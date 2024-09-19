package com.hd.document.read.ui.main.myfiles

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hd.document.read.databinding.MyFilesFragBinding
import com.hd.document.read.ui.base.BaseFragment

class MyFilesFragment : BaseFragment<MyFilesFragBinding>() {
    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MyFilesFragBinding = MyFilesFragBinding.inflate(inflater)

    private val TAG : String = "LifeCycle"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"MyFilesFragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"MyFilesFragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG,"MyFilesFragment: onCreateView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"MyFilesFragment: onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"MyFilesFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"MyFilesFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"MyFilesFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"MyFilesFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"MyFilesFragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"MyFilesFragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"MyFilesFragment: onDetach")
    }
}
