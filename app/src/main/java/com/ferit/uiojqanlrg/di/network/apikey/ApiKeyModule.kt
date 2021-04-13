package com.ferit.uiojqanlrg.di.network.apikey

import com.ferit.uiojqanlrg.utils.Keys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiKeyModule {

    @AppServiceApiKey
    @Singleton
    @Provides
    fun provideAppServiceApiKey(): String = Keys.apiKey()
}