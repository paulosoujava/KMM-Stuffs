package com.paulo.kmm.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// COMO CRIEI ESSES OBJETOS?
// pesquisa: json to kotlin data class online generator
// https://json2kt.com/
@Serializable
data class EntryResponse(
    @SerialName("count") var count: Int? = null,
    @SerialName("entries") var entries: ArrayList<Entry> = arrayListOf()
)

@Serializable
data class Entry(
    @SerialName("API") var api: String? = null,
    @SerialName("Description") var description: String? = null,
    @SerialName("Auth") var auth: String? = null,
    @SerialName("HTTPS") var https: Boolean? = null,
    @SerialName("Cors") var cors: String? = null,
    @SerialName("Link") var link: String? = null,
    @SerialName("Category") var category: String? = null
)