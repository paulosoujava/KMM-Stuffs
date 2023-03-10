package com.paulo.kmm.utils

import platform.Foundation.NSLog

actual interface CommonLogger {
    actual fun log(message: String){
        if(Platform.isDebugBinary){
            NSLog("\\%\\@: $message", "DEBUG")
        }
    }
}