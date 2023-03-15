package com.paulo.kmm.viewmodels

import com.paulo.kmm.di.DI.inject
import com.paulo.kmm.network.*
import com.paulo.kmm.network.models.Entry
import com.paulo.kmm.repositories.EntryRepository
import com.paulo.kmm.utils.CommonLogger
import com.paulo.kmm.utils.CommonLoggerImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EntryViewModel: BaseSharedViewModel() {

    private lateinit var storyRepository: EntryRepository
    private val logger: CommonLogger = CommonLoggerImpl()
    private val environment by inject<Environment>()

    private val _entries = MutableStateFlow<List<Entry>?>(null)
    val entries: StateFlow<List<Entry>?>
        get() {
            return _entries
        }
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?>
        get() {
            return _error
        }

    init {
        initEndPointService()
    }

    private fun initEndPointService() {
        val httpClient = getHttpClient(
            ClientConfig(
                environment = getAppEnvironment(), // VEJA AULA DE VARIAVEIS DE AMBIENTE
                userAgent = "Android"
            )
        )
        storyRepository = EntryRepository(ApiEndpoints(httpClient, getAppEnvironment()))
    }

    fun fetchEntries() {
        logger.log("Meu ambiente é: ${environment.name}")
        scope.launch {
            storyRepository.fetchEntries().collect { result ->
                when(result){
                    is NetworkResult.Success -> _entries.emit(result.data).also {
                        logger.log("Entries fetched successfully")
                    }
                    is NetworkResult.Error -> _error.emit(result.errorMessage).also{
                        logger.log("Entries Error ${result.errorMessage}")
                    }
                    is NetworkResult.Exception -> _error.emit(result.exception?.message).also{
                        logger.log("Entries Exception ${result.exception?.message}")
                    }
                }
            }
        }
    }
}








