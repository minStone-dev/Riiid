package com.minstone.riiid.module

import com.minstone.data.repository.PostRepositoryImpl
import com.minstone.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}