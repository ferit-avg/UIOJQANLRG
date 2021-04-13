package com.ferit.uiojqanlrg.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ferit.uiojqanlrg.data.api.MovieService
import com.ferit.uiojqanlrg.utils.Keys
import javax.inject.Inject

class MovieRepository
@Inject
constructor(
    private val movieService: MovieService
){
    fun getPopulerMovies() =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieService = movieService) }
        ).liveData
}