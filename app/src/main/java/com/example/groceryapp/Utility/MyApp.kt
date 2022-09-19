package com.example.groceryapp.Utility

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.groceryapp.BuildConfig
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by MD.Rabius sani raju on 9/19/22.
 */
class MyApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        context = this
        initializeLoggers()
        startKoin {

        }
        // Start Koin
        /*startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }*/
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