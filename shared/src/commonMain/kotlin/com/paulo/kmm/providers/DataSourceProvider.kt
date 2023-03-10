package com.paulo.kmm.providers

import com.paulo.kmm.database.Database
import com.paulo.kmm.database.createSqlDriver

class DataSourceProvider {
    private val database = Database(createSqlDriver())

    fun getLocalCommonDatabase() = database

//    Outros provedores de dados que voce poderia ter aqui mais pra frente
//    fun getXyzRepository()
//    fun getXyzUseCase()
}