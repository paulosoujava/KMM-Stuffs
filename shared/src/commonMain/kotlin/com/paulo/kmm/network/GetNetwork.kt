package com.paulo.kmm.network

import io.ktor.client.*

expect fun getAppEnvironment(): Environment
expect fun getHttpClient(clientConfig: ClientConfig): HttpClient