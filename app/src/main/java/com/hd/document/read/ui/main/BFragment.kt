package com.hd.document.read.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hd.document.read.databinding.BFragBinding
import com.hd.document.read.ui.base.BaseFragment

class BFragment : BaseFragment<BFragBinding>() {
    companion object {
        private const val TAG: String = "LifeCycle"
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {
        binding.btnBack.setOnClickListener {
            val parentFragmentManager = parentFragmentManager
            if (parentFragmentManager.backStackEntryCount > 0) {
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): BFragBinding =
        BFragBinding.inflate(inflater)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "B Fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "B Fragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG, "B Fragment: onCreateView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "B Fragment: onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "B Fragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "B Fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "B Fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "B Fragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "B Fragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "B Fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "B Fragment: onDetach")
    }
}