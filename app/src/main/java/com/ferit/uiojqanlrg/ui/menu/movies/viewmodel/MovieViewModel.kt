package com.ferit.uiojqanlrg.ui.menu.movies.viewmodel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.ferit.uiojqanlrg.data.repository.MovieRepository
import com.ferit.uiojqanlrg.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel
@Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(), LifecycleObserver {

    val getPopulerMovies = movieRepository.getPopulerMovies().cachedIn(viewModelScope)


    fun getPopulerMovies2() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = movieRepository.getPopulerMovies()))
        } catch (e: KotlinNullPointerException) {
            emit(Resource.empty(data = null, exception = e))
        } catch (e: Exception) {
            emit(Resource.error(data = null, exception = e))
        }
    }

}