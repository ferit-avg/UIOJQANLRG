package com.ferit.uiojqanlrg.data.api

import com.ferit.uiojqanlrg.data.model.movie.Movie
import com.ferit.uiojqanlrg.data.model.response.ListPopulerMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopulerMovies(@Query("page") page: Int): ListPopulerMovieResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: Int
    ): Movie
}