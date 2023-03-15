package com.paulo.kmm.android.resources

import android.content.res.Configuration
import androidx.compose.ui.graphics.Color
import com.paulo.kmm.android.utils.AndroidMainApp

actual fun isSystemInDarkMode(): Boolean {
    val uiMode = AndroidMainApp.applicationContext.resources.configuration.uiMode
    return (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}

actual class ColorResource actual constructor(private val colorHexValue: Long): IosColor(colorHexValue) {
    fun getColor() = Color(colorHexValue)
}