package com.paulo.kmm

import kotlinx.coroutines.CoroutineScope



expect abstract class BaseAndroidViewModel(){
    val scope: CoroutineScope
    protected fun onCleared()
}