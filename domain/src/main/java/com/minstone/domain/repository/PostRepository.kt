package com.minstone.domain.repository

import com.minstone.domain.model.response.PostListModel
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(page: Int, perPage: Int): Flow<List<PostListModel>>
}