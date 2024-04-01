package com.minstone.data.remote.mapper

import com.minstone.data.remote.dto.response.PostList
import com.minstone.domain.model.response.PostListModel

fun List<PostList>.toPostListModel() =
    map {
        PostListModel(
            id = it.id,
            userId = it.userId,
            title = it.title,
            body = it.body
        )
    }