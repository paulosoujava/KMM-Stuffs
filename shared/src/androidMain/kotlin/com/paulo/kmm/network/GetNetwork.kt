package com.paulo.kmm.android.network

import com.paulo.kmm.android.di.DI
import io.ktor.client.*

actual fun getAppEnvironment(): Environment = DI.Native.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)