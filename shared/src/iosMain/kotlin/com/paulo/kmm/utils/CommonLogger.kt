package com.paulo.kmm.utils

//import platform.Foundation.NSLog

actual interface CommonLogger {
    actual fun log(message:String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(Platform.isDebugBinary){
           //NSLog("\\%\\@: $message", "DEBUG")
        }
    }
}