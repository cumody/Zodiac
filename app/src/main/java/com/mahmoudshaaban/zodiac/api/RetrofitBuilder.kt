package com.mahmoudshaaban.zodiac.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    const val BASE_URL = "https://api.themoviedb.org/3/"


    val retrofit: Retrofit.Builder by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())


    }

    val apiService : Api by lazy {
        retrofit
            .build()
            .create(Api::class.java)
    }

}