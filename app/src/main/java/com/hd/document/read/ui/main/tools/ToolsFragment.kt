package com.hd.document.read.ui.main.tools

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hd.document.read.databinding.ToolsFragBinding
import com.hd.document.read.ui.base.BaseFragment

class ToolsFragment : BaseFragment<ToolsFragBinding>() {
    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {

    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): ToolsFragBinding =
        ToolsFragBinding.inflate(inflater)

    private val TAG : String = "LifeCycle"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"ToolsFragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"ToolsFragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG,"ToolsFragment: onCreateView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"ToolsFragment: onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"ToolsFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"ToolsFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"ToolsFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"ToolsFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"ToolsFragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"ToolsFragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"ToolsFragment: onDetach")
    }
}