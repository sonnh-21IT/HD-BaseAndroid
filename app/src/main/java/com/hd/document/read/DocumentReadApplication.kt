package com.hd.document.read

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.hd.document.read.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DocumentReadApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }


    private fun setupKoin() {
        startKoin {
            androidContext(this@DocumentReadApplication)
            modules(
                appModule
            )
        }
    }
}