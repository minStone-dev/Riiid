package com.minstone.data.remote.datasource

import com.minstone.data.remote.dto.response.PostList
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    suspend fun getPost(page: Int, perPage: Int): Flow<List<PostList>>
}