package com.mahmoudshaaban.zodiac.model

import com.google.gson.annotations.SerializedName

data class GetMovieResponse(
    @SerializedName("page") val page : Int ,
    @SerializedName("total_results") val totalResults : Int ,
    @SerializedName("total_pages") val total_pages : Int ,
    @SerializedName("results") val results : List<Movie>
)