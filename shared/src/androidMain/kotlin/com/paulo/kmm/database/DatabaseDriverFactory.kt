package com.paulo.kmm.database

import br.com.progdeelite.kmmprogdeelite.database.CommonDatabase
import com.paulo.kmm.utils.AndroidApplication
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun createSqlDriver(): SqlDriver {
    return AndroidSqliteDriver(CommonDatabase.Schema, AndroidApplication.context, "common.db")
}