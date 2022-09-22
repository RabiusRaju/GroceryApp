package com.example.groceryapp.utility

import android.content.Context
import android.graphics.Typeface
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View

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

/*
* User Define String Text Style defined
* */
fun getSpanString(normal: String, bold: String): Spannable? {
    val finalString = normal + bold
    val sb: Spannable = SpannableString(normal + bold)
    sb.setSpan(
        StyleSpan(Typeface.BOLD),
        normal.length,
        finalString.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return sb
}
/*
* Hardware related  extension
* */
fun isLocationEnabled(context: Context): Boolean {
    val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    var gpsEnabled = false
    try {
        gpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
    } catch (ex: Exception) {
    }
    return gpsEnabled
}

/*
* Activity & Fragment related view Control extension
* */

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}