package com.paulo.kmm

class IOSPlatform: Platform {
    override val name: String = "Alô iOS Freaks!"
}

actual fun getPlatform(): Platform = IOSPlatform()