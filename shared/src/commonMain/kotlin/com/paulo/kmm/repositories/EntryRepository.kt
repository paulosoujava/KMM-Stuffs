package com.paulo.kmm.repositories

import com.paulo.kmm.network.Endpoints
import com.paulo.kmm.network.NetworkResult
import com.paulo.kmm.network.models.Entry
import kotlinx.coroutines.flow.Flow

// 1) COMO CRIAR O REPOSITORY
// 2) COMO CRIAR O VIEWMODEL PARA EMITIR UM FLOW
// 3) COMO USAR O VIEWMODEL NA PRÁTICA DENTRO DA VIEW

interface EntrySourceType {
    suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>>
}

class EntryRepository(private val entryEndpoint: Endpoints.Entries): EntrySourceType {
    override suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>> {
        return entryEndpoint.getEntries()
    }
}