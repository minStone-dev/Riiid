package com.minstone.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class PostList(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)
