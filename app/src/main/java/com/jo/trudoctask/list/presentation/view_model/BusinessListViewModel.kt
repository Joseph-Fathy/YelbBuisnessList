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

/**
 * The view model of the business list fragment , it's responsible to get the list using the use case
 * and notify the view with the result
 *
 * @property useCase instance of [GetBusinessesListUseCase] to get the list of businesses
 * @property defaultDispatcher the dispatcher used to specify the coroutine scope
 */
class BusinessListViewModel @ViewModelInject constructor(
    private val useCase: GetBusinessesListUseCase,
    @IOCoroutineDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {
    var viewState = BusinessListViewState()
    var viewStateLiveData = MutableLiveData<BusinessListViewState>()

    init {
        viewStateLiveData.value = viewState.copy(isLoading = true)
    }

    /**
     * Get the list of businesses using the use case
     *
     * @param page the page wanted to load it's content starting from 0
     */
    fun getBusinessList(page: Int) {
        viewModelScope.launch(defaultDispatcher) {
            val offset = page * resultsLimitCount
            val result = useCase.getBusinessList(offset = offset)
            viewState = handle(result)
            viewStateLiveData.postValue(viewState)
        }

    }

    /**
     * Handle the result of the use case and covert it to view state
     *
     * @param result instance of BusinessesListResult that contains the data and the state
     * @return instance of BusinessListViewState contains the state of the view
     */
    private fun handle(result: BusinessesListResult): BusinessListViewState {
        return when (result) {
            is BusinessesListResult.Loading -> viewState.copy(isLoading = true)
            is BusinessesListResult.Empty -> viewState.copy(isEmpty = true)
            is BusinessesListResult.Error -> viewState.copy(error = result.error)
            is BusinessesListResult.Data -> viewState.copy(data = result.data)
        }
    }


}