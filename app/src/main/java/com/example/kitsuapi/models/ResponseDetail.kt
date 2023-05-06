package com.example.kitsuapi.models

import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("data")
    val data: DataItem
)