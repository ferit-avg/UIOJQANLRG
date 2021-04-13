package com.ferit.uiojqanlrg.data.model.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("original_language")
    @Expose
    val original_language: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int,
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (original_language != other.original_language) return false
        if (title != other.title) return false
        if (originalTitle != other.originalTitle) return false
        if (overview != other.overview) return false
        if (posterPath != other.posterPath) return false
        if (releaseDate != other.releaseDate) return false
        if (voteAverage != other.voteAverage) return false
        if (voteCount != other.voteCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + original_language.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + originalTitle.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + posterPath.hashCode()
        result = 31 * result + releaseDate.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + voteCount
        return result
    }

    override fun toString(): String {
        return "Movie(id=$id, original_language='$original_language', title='$title', originalTitle='$originalTitle', overview='$overview', posterPath='$posterPath', releaseDate='$releaseDate', voteAverage=$voteAverage, voteCount=$voteCount)"
    }
}
