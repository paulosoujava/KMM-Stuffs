package com.paulo.kmm.network


import com.paulo.kmm.utils.AndroidApplication
import io.ktor.client.*

actual fun getAppEnvironment(): Environment = AndroidApplication.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)