package com.paulo.kmm.di

import com.paulo.kmm.di.DI.Native.environment
import com.paulo.kmm.di.DI.Native.lokalisable
import com.paulo.kmm.localization.Localization
import com.paulo.kmm.localization.LocalizationService
import com.paulo.kmm.localization.Lokalisable
import com.paulo.kmm.network.Environment
import com.paulo.kmm.settings.AppSettings
import com.paulo.kmm.settings.SettingsService
import kotlin.native.concurrent.ThreadLocal

// 1) Renomear AndroidApp para AndroidMainApp e criar IOSMainApp
// 2) Mover dependencias comuns para DI
// 3) Criar DependencyInjectionForPreview para android
// 4) Defnir Fakes para Android
// 5) Mostrar no OnboardingViewModel e OnboardingScreen


/**
 * CUSTOM DEPENDENCY INJECTION - HOW TO USE IT:
 *
 * 1) Add dependency either to Native (direct in lookup from method inject)
 * 2) If Native, initialize it by assigning its value over MainApplication(Android)/UIApplicationDelegate(iOS)
 * 3) Add new lookup to inject method
 *
 * Usage (example):
 * val environments by inject<Environment>() OR val environment: Environment by inject()
 */
object DI {

    @ThreadLocal
    object Native {
        // 1)
        lateinit var environment: Environment // 2) will be initialized in MainApplication/UIApplicationDelegate
        lateinit var lokalisable: Lokalisable
    }

    inline fun <reified T> inject(): Lazy<T> {
        // 3)
        return when (T::class) {
            Environment::class -> lazy { environment as T }
            Lokalisable::class -> lazy { lokalisable as T }
            LocalizationService::class -> lazy { Localization() as T }
            SettingsService::class -> lazy { AppSettings() as T }
            else -> throw IllegalArgumentException("Dependency not found! Specify class \"${T::class.qualifiedName}\" in DI.inject()")
        }
    }

    // for android preview [see DependencyInjectionForPreview] and testing later on
    fun fake() = fakeDI()
}