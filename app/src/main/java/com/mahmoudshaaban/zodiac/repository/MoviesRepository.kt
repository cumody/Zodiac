package com.mahmoudshaaban.zodiac.repository

import android.util.Log
import com.mahmoudshaaban.zodiac.api.RetrofitBuilder
import com.mahmoudshaaban.zodiac.model.GetMovieResponse
import com.mahmoudshaaban.zodiac.model.Movie
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

object MoviesRepository {

    private const val TAG = "Repository"

    fun getMovies(
        page: Int = 1
        , onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        RetrofitBuilder.apiService.getListMovies(page = page)
            .enqueue(object : retrofit2.Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.results)
                        } else {
                            val error = onError.invoke()
                            Log.e(TAG, "onResponse: ")

                        }
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }
            })
    }


        fun getTopRatedMovies(
            page: Int = 1,
            onSuccess: (movies: List<Movie>) -> Unit,
            onError: () -> Unit
        ) {
            RetrofitBuilder.apiService.getTopRated(page = page)
                .enqueue(object : retrofit2.Callback<GetMovieResponse> {
                    override fun onResponse(
                        call: Call<GetMovieResponse>,
                        response: Response<GetMovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()

                            if (responseBody != null) {
                                onSuccess.invoke(responseBody.results)
                            } else {
                                onError.invoke()
                            }
                        } else {
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                        onError.invoke()
                    }
                })
        }
    }
