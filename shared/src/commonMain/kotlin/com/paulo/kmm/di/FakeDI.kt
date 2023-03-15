package com.paulo.kmm.di

import com.paulo.kmm.localization.Language
import com.paulo.kmm.localization.Lokalisable
import com.paulo.kmm.network.Environment

internal fun fakeDI(){
    DI.Native.environment = Environment.DEV
    DI.Native.lokalisable = FakeLokalise()
}

class FakeLokalise: Lokalisable {
    override fun lokalise(stringRef: String): String = stringRef
    override fun loadResources() {}
    override fun changeLanguage(language: Language) {}
    override fun geLokaliseLanguage(): Language = Language.getDefaultLanguage()
}