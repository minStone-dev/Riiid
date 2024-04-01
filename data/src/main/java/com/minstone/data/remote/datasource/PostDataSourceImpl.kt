package com.minstone.data.remote.datasource

import com.minstone.data.remote.api.PostAPI
import com.minstone.data.remote.dto.response.PostList
import com.minstone.data.util.RiiidApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val api: PostAPI
): PostDataSource {
    override suspend fun getPost(page: Int, perPage: Int): Flow<List<PostList>> = flow {
        emit(
            RiiidApiHandler<List<PostList>>()
                .httpRequest { api.getPosts(page, perPage) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}