package com.ferit.uiojqanlrg.ui.menu.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferit.uiojqanlrg.R
import com.ferit.uiojqanlrg.data.model.common.AlertStatusType
import com.ferit.uiojqanlrg.data.model.movie.Movie
import com.ferit.uiojqanlrg.databinding.FragmentPopularMoviesBinding
import com.ferit.uiojqanlrg.ext.AlertCallback
import com.ferit.uiojqanlrg.ext.navigate
import com.ferit.uiojqanlrg.ui.UIMessage
import com.ferit.uiojqanlrg.ui.UIMessageType
import com.ferit.uiojqanlrg.ui.base.BaseFragment
import com.ferit.uiojqanlrg.ui.menu.movies.adapter.PopulerMovieAdapter
import com.ferit.uiojqanlrg.ui.menu.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : BaseFragment(R.layout.fragment_popular_movies),
    PopulerMovieAdapter.Interaction {
    private var _binding: FragmentPopularMoviesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        initRecyclerView()

        handleClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvPopularMovies.adapter = null
        _binding = null
    }

    override fun onSelectedMovie(position: Int, movie: Movie) {
        navigate(PopularMoviesFragmentDirections.actionPopularMoviesFragmentToMovieDetailsFragment(movieId = movie.id, movie = movie))
    }

    private fun handleClickListeners() {
        //TODO("Not yet implemented")
    }

    private fun initRecyclerView() {

        val populerMovieAdapter = PopulerMovieAdapter(this)

        binding.rvPopularMovies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = populerMovieAdapter
        }

        viewModel.getPopulerMovies.observe(viewLifecycleOwner, {
            populerMovieAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        })

        populerMovieAdapter.addLoadStateListener { combinedLoadStates ->
            when(combinedLoadStates.source.refresh) {
                is LoadState.Loading -> {
                    // TODO
                }
                is LoadState.NotLoading -> {
                    // TODO
                }
                is LoadState.Error -> {
                    // TODO
                }
            }
        }
    }

    private fun setupUI() {
        //TODO("Not yet implemented")
    }

    private fun handleError() {
        val callback: AlertCallback = object : AlertCallback {
            override fun proceed() {}

            override fun cancel() {}
        }
        communicationListener.onUIMessageReceived(
            UIMessage(
                getString(R.string.ERROR),
                UIMessageType.Dialog(callback)
            ), AlertStatusType.ERROR.code,
            getString(R.string.TRY_AGAIN)
        )
    }

}