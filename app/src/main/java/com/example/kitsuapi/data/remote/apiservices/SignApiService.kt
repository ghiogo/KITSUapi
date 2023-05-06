package com.example.kitsuapi.data.remote.apiservices

import com.example.kitsuapi.models.auth.AuthModel
import com.example.kitsuapi.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignApiService {
    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}