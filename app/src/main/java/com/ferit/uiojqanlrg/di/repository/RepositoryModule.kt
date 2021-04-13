package com.ferit.uiojqanlrg.di.repository

import com.ferit.uiojqanlrg.data.api.MovieService
import com.ferit.uiojqanlrg.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieService: MovieService): MovieRepository {
        return MovieRepository(movieService)
    }
}