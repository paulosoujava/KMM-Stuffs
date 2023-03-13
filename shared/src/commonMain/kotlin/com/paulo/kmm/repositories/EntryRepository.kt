package com.paulo.kmm.repositories


import com.paulo.kmm.network.Endpoints
import com.paulo.kmm.network.NetworkResult
import com.paulo.kmm.network.models.Entry
import kotlinx.coroutines.flow.Flow

interface EntrySourceType {
    suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>>
}

class EntryRepository(private val entryEndpoint: Endpoints.Entries): EntrySourceType {
    override suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>> {
        return entryEndpoint.getEntries()
    }
}