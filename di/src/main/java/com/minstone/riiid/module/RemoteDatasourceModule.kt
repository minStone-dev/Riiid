package com.minstone.riiid.module

import com.minstone.data.remote.datasource.PostDataSource
import com.minstone.data.remote.datasource.PostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDatasourceModule {
    @Binds
    abstract fun providePostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource
}