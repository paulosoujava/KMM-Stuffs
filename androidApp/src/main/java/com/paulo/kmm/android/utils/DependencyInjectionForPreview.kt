package com.paulo.kmm.android.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.paulo.kmm.di.DI
import com.paulo.kmm.utils.AndroidMainApp

@Composable
fun DependencyInjectionForPreview() {
    AndroidMainApp.applicationContext = LocalContext.current.applicationContext
    DI.fake()
}