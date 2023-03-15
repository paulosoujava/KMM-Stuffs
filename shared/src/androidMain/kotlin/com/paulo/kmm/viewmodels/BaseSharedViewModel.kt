package com.paulo.kmm.android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual abstract class BaseSharedViewModel: ViewModel() {

    actual val scope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}