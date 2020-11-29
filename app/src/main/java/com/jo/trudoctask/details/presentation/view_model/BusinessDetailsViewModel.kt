package com.jo.trudoctask.details.presentation.view_model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jo.trudoctask.common.di.IOCoroutineDispatcher
import com.jo.trudoctask.details.domain.result.BusinessDetailsResult
import com.jo.trudoctask.details.domain.usecase.GetBusinessDetailsUseCase
import com.jo.trudoctask.details.domain.usecase.GetBusinessDetailsUseCaseInput
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class BusinessDetailsViewModel @ViewModelInject constructor(
    private val useCase: GetBusinessDetailsUseCase,
    @IOCoroutineDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var viewState = BusinessDetailsViewState()
    val viewStateLiveData = MutableLiveData<BusinessDetailsViewState>()

    fun getBusinessDetails(id: String) {
        viewModelScope.launch(defaultDispatcher) {
            viewStateLiveData.postValue(viewState.copy(loading = true))
            val result = useCase.execute(GetBusinessDetailsUseCaseInput(id))
            viewState = handle(result)
            viewStateLiveData.postValue(viewState)
        }
    }

    private fun handle(result: BusinessDetailsResult): BusinessDetailsViewState {
        return when (result) {
            is BusinessDetailsResult.Loading -> viewState.copy(loading = true)
            is BusinessDetailsResult.Empty -> viewState.copy(empty = true)
            is BusinessDetailsResult.Error -> viewState.copy(error = result.error)
            is BusinessDetailsResult.Data -> viewState.copy(data = result.data)
        }
    }
}