package com.example.kyle.githubapi.login

import com.squareup.moshi.Json

data class AccessToken(

        @Json(name = "access_token")
        val accessToken: String,

        @Json(name = "token_name")
        val tokenType: String
)