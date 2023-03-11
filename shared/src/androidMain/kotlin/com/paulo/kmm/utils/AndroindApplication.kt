package com.paulo.kmm.utils

import android.annotation.SuppressLint
import android.content.Context
import com.paulo.kmm.network.Environment

@SuppressLint("StaticFieldLeak")
class AndroidApplication {
    companion object{
        lateinit var  context: Context
        lateinit var  environment: Environment
    }
}