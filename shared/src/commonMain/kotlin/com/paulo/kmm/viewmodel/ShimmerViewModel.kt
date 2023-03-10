package com.paulo.kmm.viewmodel

import com.paulo.kmm.BaseSharedViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShimmerViewModel: BaseSharedViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun toggle(){
        scope.launch {
            _loading.emit(_loading.value.not())
        }
    }
}