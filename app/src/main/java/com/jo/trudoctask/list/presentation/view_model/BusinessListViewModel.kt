package com.jo.trudoctask.list.presentation.view_model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jo.trudoctask.common.Constants.resultsLimitCount
import com.jo.trudoctask.common.di.IOCoroutineDispatcher
import com.jo.trudoctask.list.domain.result.BusinessesListResult
import com.jo.trudoctask.list.domain.usecase.GetBusinessesListUseCase
import com.jo.trudoctask.list.presentation.view_state.BusinessListViewState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class BusinessListViewModel @ViewModelInject constructor(
    private val useCase: GetBusinessesListUseCase,
    @IOCoroutineDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {
    var viewState = BusinessListViewState()
    var viewStateLiveData = MutableLiveData<BusinessListViewState>()

    init {
        getBusinessList(0)
        viewStateLiveData.value = viewState.copy(isLoading = true)
    }

    fun getBusinessList(page: Int) {
        viewModelScope.launch(defaultDispatcher) {

            val offset = page * resultsLimitCount
            val result = useCase.getBusinessList(offset = offset)
            viewState = handle(result)
            viewStateLiveData.postValue(viewState)
        }

    }

    private fun handle(result: BusinessesListResult): BusinessListViewState {
        return when (result) {
            is BusinessesListResult.Loading -> viewState.copy(isLoading = true)
            is BusinessesListResult.Empty -> viewState.copy(isEmpty = true)
            is BusinessesListResult.Error -> viewState.copy(error = result.error)
            is BusinessesListResult.Data -> viewState.copy(data = result.data)
        }
    }


}