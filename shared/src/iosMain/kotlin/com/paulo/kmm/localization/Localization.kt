package com.paulo.kmm.localization

/** iOS only needs the string reference to resolve its text resource. Just fine that way */
actual fun getDefaultString(name: String): String = name