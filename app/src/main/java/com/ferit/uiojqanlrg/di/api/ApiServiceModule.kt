package com.ferit.uiojqanlrg.di.api

import com.ferit.uiojqanlrg.data.api.MovieService
import com.ferit.uiojqanlrg.di.network.AppServiceRetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideMovieService(@AppServiceRetrofitInstance retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}