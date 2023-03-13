package com.paulo.kmm.models

import com.paulo.kmm.network.models.Entry
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class EntryResponse(
    @SerialName("count") var count: Int? = null,
    @SerialName("entries") var entries: ArrayList<Entry> = arrayListOf()
)

@kotlinx.serialization.Serializable
data class Entry(
    @SerialName("API") var api: String? = null,
    @SerialName("Description") var description: String? = null,
    @SerialName("Auth") var auth: String? = null,
    @SerialName("HTTPS") var https: Boolean? = null,
    @SerialName("Cors") var cors: String? = null,
    @SerialName("Link") var link: String? = null,
    @SerialName("Category") var category: String? = null
)