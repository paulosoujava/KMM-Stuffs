package com.paulo.kmm.utils

import android.util.Log
import com.paulo.kmm.android.BuildConfig

actual interface CommonLogger {
    actual fun log(message: String){
        if(BuildConfig.DEBUG){
            Log.d(BuildConfig.BUILD_TYPE, message)
        }
    }
}