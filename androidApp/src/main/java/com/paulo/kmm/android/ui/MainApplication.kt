package com.paulo.kmm.android.ui

import android.app.Application
import android.content.Context
import com.paulo.kmm.android.CommonConfig
import com.paulo.kmm.android.localization.AndroidLocalisable
import com.paulo.kmm.di.DI
import com.paulo.kmm.network.Environment
// import androidx.navigation.NavHostController // TODO: nav
import com.paulo.kmm.utils.AndroidMainApp

class MainApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject dependencies into androidMain
            AndroidMainApp.applicationContext = it
            DI.Native.lokalisable = com.paulo.kmm.android.localization.AndroidLocalisable(it)
        }
        setEnvironment()
    }

    // APENAS PARA FINS DIDÁTICOS ASSIM. PARA MAIS DETALHES VEJA:
    // - https://developer.android.com/studio/build/build-variants#kts
    // - https://developer.android.com/studio/build
    private fun setEnvironment() {
        // TODO: comentado pois não esta sendo usado no projeto, apenas para fins didáticos
        DI.Native.environment = Environment.getEnvironmentByBuildFlavor("CommonConfig.FLAVOR")
    }
}