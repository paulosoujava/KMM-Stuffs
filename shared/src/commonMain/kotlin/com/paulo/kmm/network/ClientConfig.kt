package com.paulo.kmm.network

/**
 * Client configuration to be applied whenever a HttpClient is created
 */
data class ClientConfig(
    /** To be used as environment switcher */
    val environment: Environment,

    /** To be used while sending requests "MOBILE", "WEB" or any other identifier you define */
    var userAgent: String
)