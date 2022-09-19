package com.example.groceryapp.Utility

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.groceryapp.BuildConfig
import timber.log.Timber

/**
 * Created by MD.Rabius sani raju on 9/19/22.
 */
class MyApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        context = this
        initializeLoggers()
    }

    companion object{
        @JvmField
        var context:Context?=null
    }

    private fun initializeLoggers() {
        if (BuildConfig.DEBUG){
            Timber.plant(CustomDebugTree())
        }
    }
}