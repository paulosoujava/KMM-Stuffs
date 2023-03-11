package com.paulo.kmm.utils

import com.paulo.kmm.network.Environment

@ThreadLocal
object IOSApp {
    lateinit var environment: Environment
}