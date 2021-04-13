package com.ferit.uiojqanlrg.data.repository

import androidx.paging.PagingSource
import com.ferit.uiojqanlrg.data.api.MovieService
import com.ferit.uiojqanlrg.data.model.movie.Movie
import retrofit2.HttpException

class MoviePagingSource(
    private val movieService: MovieService
): PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageNumber = params.key ?: INITIAL_PAGE

        return try {
            val response = movieService.getPopulerMovies(page = pageNumber)
            val movies = response.results

            LoadResult.Page(
                data = movies,
                prevKey = if (pageNumber == INITIAL_PAGE) null else pageNumber -1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val INITIAL_PAGE = 1
    }
}