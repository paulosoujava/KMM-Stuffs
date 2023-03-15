package com.paulo.kmm.android.database

import com.paulo.kmm.android.utils.AndroidMainApp
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidMainApp.applicationContext, "common.db")
}