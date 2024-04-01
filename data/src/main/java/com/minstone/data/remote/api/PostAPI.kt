package com.minstone.data.remote.api

import com.minstone.data.remote.dto.response.PostList
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {
    @GET("posts")
    suspend fun getPosts(
        @Query("_start") page: Int,
        @Query("_limit") perPage: Int
    ): List<PostList>
}