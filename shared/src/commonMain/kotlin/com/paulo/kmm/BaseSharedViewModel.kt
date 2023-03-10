package com.paulo.kmm

import kotlinx.coroutines.CoroutineScope



expect abstract class BaseSharedViewModel(){
    val scope: CoroutineScope
    protected fun onCleared()
}