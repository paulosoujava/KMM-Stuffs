package com.paulo.kmm.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

// TODO: nav
//import androidx.navigation.NavHostController
//import com.paulo.kmm.android.navigation.Navigation
//import com.paulo.kmm.android.utils.AndroidApp

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

// PLAYGROUND ONLY
//actual abstract class BaseSharedViewModel: ViewModel()/*, Navigation TODO: nav */  {
//
//    actual val scope = viewModelScope
//
//    // private val navigator: NavHostController = AndroidApp.navHostController // TODO nav
//
//    actual override fun onCleared() {
//        super.onCleared()
//    }
//
//     TODO: nav
//    override fun navigateTo(destination: String) {
//        navigator.navigate(destination)
//    }
//
//    override fun navigateToButRemoveBackStack(destination: String) {
//        navigator.popBackStack(destination, true)
//    }
//}