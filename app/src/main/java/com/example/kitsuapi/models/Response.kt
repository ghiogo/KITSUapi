package com.example.kitsuapi.models

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: Links
)