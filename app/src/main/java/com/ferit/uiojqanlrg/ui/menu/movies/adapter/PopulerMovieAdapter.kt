package com.ferit.uiojqanlrg.ui.menu.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ferit.uiojqanlrg.data.model.movie.Movie
import com.ferit.uiojqanlrg.databinding.ItemMovieBinding
import com.ferit.uiojqanlrg.BuildConfig.IMAGE_BASE_URL

class PopulerMovieAdapter(private val interaction: Interaction? = null) :
    PagingDataAdapter<Movie, PopulerMovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding, interaction)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class MovieViewHolder(val binding: ItemMovieBinding, private val interaction: Interaction?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvMovieTitle.text = movie.originalTitle
            Glide.with(itemView).load("$IMAGE_BASE_URL${movie.backdropPath}")
                .into(binding.ivPoster)

            binding.root.setOnClickListener {
                interaction?.onSelectedMovie(position = bindingAdapterPosition, movie = movie)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface Interaction {
        fun onSelectedMovie(position: Int, movie: Movie)
    }
}