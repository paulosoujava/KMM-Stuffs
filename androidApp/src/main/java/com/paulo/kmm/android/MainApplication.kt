package com.paulo.kmm.android

import android.app.Application
import android.content.Context
import com.paulo.kmm.network.Environment
import com.paulo.kmm.utils.AndroidApplication

class MainApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject dependencies into androidMain
            AndroidApplication.context = it
            setEnvironment()
        }

    }

    // APENAS PARA FINS DIDÁTICOS ASSIM. PARA MAIS DETALHES VEJA:
    // - https://developer.android.com/studio/build/build-variants#kts
    // - https://developer.android.com/studio/build
    private fun setEnvironment() {
        // TODO: comentado pois não esta sendo usado no projeto, apenas para fins didáticos
        AndroidApplication.environment = Environment.getEnvironmentByBuildFlavor(BuildConfig.FLAVOR)
    }

}