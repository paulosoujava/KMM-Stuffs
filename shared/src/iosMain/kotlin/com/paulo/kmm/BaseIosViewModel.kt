package com.paulo.kmm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel


actual abstract class BaseAndroidViewModel{

    actual val scope: CoroutineScope = MainScope()

    protected actual open fun onCleared(){
        //clear stuffs
    }
    fun clear(){
        onCleared()
        scope.cancel()
    }
}

