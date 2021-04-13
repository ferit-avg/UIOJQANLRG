package com.ferit.uiojqanlrg.ui.menu.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ferit.uiojqanlrg.BuildConfig.IMAGE_BASE_URL
import com.ferit.uiojqanlrg.R
import com.ferit.uiojqanlrg.databinding.FragmentMovieDetailsBinding
import com.ferit.uiojqanlrg.ui.base.BaseFragment
import com.ferit.uiojqanlrg.ui.menu.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment: BaseFragment(R.layout.fragment_movie_details) {
    private var _binding: FragmentMovieDetailsBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModels()

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        handleMovie()

        handleClickListeners()
    }

    private fun handleMovie() {
        val movie = args.movie
        binding.apply {
            tvMovieTitle.text = movie.originalTitle
            tvMovieRating.text = "${movie.voteAverage}/${movie.voteCount}"
            tvMovieOverview.text = movie.overview
            Glide.with(requireContext()).load("$IMAGE_BASE_URL${args.movie.backdropPath}").into(ivPoster)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleClickListeners() {
        //TODO("Not yet implemented")
    }

    private fun setupUI() {
        //TODO("Not yet implemented")
    }

}