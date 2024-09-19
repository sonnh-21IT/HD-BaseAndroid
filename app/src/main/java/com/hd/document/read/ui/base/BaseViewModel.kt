package com.hd.document.read.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<Int> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }

    fun showLoading() {
        loader.value = true
    }

    fun closeLoading() {
        loader.value = false
    }

    fun showLoadingError(message: Int) {
        error.value = message
    }

}
