package com.example.groceryapp.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.groceryapp.MyApp.Companion.context

/**
 * Created by MD.Rabius sani raju on 9/22/22.
 */

@Suppress("DEPRECATION")
fun  isOnline(context: Context?): Boolean {
    var connected = false
    @Suppress("LiftReturnOrAssignment")
    context?.let {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = cm.activeNetwork ?: return false
            val actNw = cm.getNetworkCapabilities(networkCapabilities) ?: return false
            connected = actNw.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val netInfo = cm.activeNetworkInfo
            connected = netInfo?.isConnectedOrConnecting == true
        }
    }
    return connected
}