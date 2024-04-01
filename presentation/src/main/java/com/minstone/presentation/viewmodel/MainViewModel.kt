package com.minstone.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minstone.domain.model.response.PostListModel
import com.minstone.domain.model.response.PostListResponseModel
import com.minstone.domain.usecase.GetPostListUseCase
import com.minstone.presentation.viewmodel.util.Event
import com.minstone.presentation.viewmodel.util.Result
import com.minstone.presentation.viewmodel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase
) : ViewModel() {
    private val _getPostListResponse = MutableStateFlow<Event<List<PostListModel>>>(Event.Loading)
    val getPostListResponse = _getPostListResponse.asStateFlow()

    fun getPostList(page: Int = 0, perPage: Int = 10) = viewModelScope.launch {
        getPostListUseCase(page, perPage)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> { Log.d("testt","Loading") }
                    is Result.Success -> {
                        _getPostListResponse.value = Event.Success(data = result.data)
                    }
                    is Result.Error -> { Log.d("testt",result.exception.toString()) }
                }

            }
    }
}