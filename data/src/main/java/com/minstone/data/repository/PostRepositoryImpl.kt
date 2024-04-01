package com.minstone.data.repository

import com.minstone.data.remote.datasource.PostDataSource
import com.minstone.data.remote.dto.response.PostList
import com.minstone.data.remote.mapper.toPostListModel
import com.minstone.domain.model.response.PostListModel
import com.minstone.domain.model.response.PostListResponseModel
import com.minstone.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource
): PostRepository {
    override suspend fun getPost(page: Int, perPage: Int): Flow<List<PostListModel>> {
        return postDataSource.getPost(page,perPage).map { it.toPostListModel() }
    }
}