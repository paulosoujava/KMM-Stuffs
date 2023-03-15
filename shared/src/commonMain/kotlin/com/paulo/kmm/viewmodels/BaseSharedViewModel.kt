package com.paulo.kmm.viewmodels

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseSharedViewModel() {
    val scope: CoroutineScope
    protected fun onCleared()
}