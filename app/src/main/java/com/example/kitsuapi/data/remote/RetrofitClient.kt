package com.example.kitsuapi.data.remote

import com.example.kitsuapi.data.remote.apiservices.AnimeApiService
import com.example.kitsuapi.data.remote.apiservices.MangaApiService
import com.example.kitsuapi.data.remote.apiservices.SignApiService
import com.example.kitsuapi.data.repositories.TokenInterceptor
import com.example.kitsuapi.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor()).connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)

    fun provideMangaApiService() = retrofitClient.create(MangaApiService::class.java)

    fun providerSignInApiService() = retrofitClient.create(SignApiService::class.java)
}