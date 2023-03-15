package com.paulo.kmm.android.localization

import android.annotation.SuppressLint
import android.content.res.Resources.NotFoundException
import com.paulo.kmm.android.utils.AndroidMainApp

@SuppressLint("DiscouragedApi")
actual fun getDefaultString(name: String): String {
    return with(AndroidMainApp.applicationContext) {
        try {
            getString(resources.getIdentifier(name, "string", packageName))
        } catch (ex: NotFoundException){
            name
        }
    }
}