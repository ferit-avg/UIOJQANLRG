package com.ferit.uiojqanlrg.data.model.response

import com.ferit.uiojqanlrg.data.model.movie.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListPopulerMovieResponse(
    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("results")
    @Expose
    val results: List<Movie>,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int,

    @SerializedName("total_results")
    @Expose
    val totalResults: Int
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListPopulerMovieResponse

        if (page != other.page) return false
        if (results != other.results) return false
        if (totalPages != other.totalPages) return false
        if (totalResults != other.totalResults) return false

        return true
    }

    override fun hashCode(): Int {
        var result = page
        result = 31 * result + results.hashCode()
        result = 31 * result + totalPages
        result = 31 * result + totalResults
        return result
    }

    override fun toString(): String {
        return "ListPopulerMovieResponse(page=$page, results=$results, totalPages=$totalPages, totalResults=$totalResults)"
    }
}