package com.minstone.domain.usecase

import com.minstone.domain.model.response.PostListModel
import com.minstone.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(page: Int, perPage: Int): Flow<List<PostListModel>> =
        postRepository.getPost(page, perPage)
}