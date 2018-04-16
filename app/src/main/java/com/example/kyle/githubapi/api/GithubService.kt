package com.example.kyle.githubapi.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GithubService {

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.api.github.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

}