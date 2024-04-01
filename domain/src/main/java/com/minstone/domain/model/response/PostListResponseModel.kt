package com.minstone.domain.model.response

data class PostListModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
