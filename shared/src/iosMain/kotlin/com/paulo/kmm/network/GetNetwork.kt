package com.paulo.kmm.network

import com.paulo.kmm.di.DI
import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual fun getAppEnvironment(): Environment = DI.Native.environment

actual fun getHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(Darwin) {
        engine {
            configureRequest {
                //setAllowsCellularAccess(true)
            }
        }
    }
}