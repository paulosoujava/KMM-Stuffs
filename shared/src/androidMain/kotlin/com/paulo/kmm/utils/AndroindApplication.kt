package com.paulo.kmm.utils

import android.annotation.SuppressLint
import android.content.Context

class AndroidApplication {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var  context: Context
    }
}