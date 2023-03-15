package com.paulo.kmm.android.utils

import android.util.Log
import com.paulo.kmm.android.BuildConfig

actual interface CommonLogger {
    actual fun log(message:String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(BuildConfig.DEBUG){
            Log.d(BuildConfig.BUILD_TYPE, message)
        }
    }
}