package com.jo.trudoctask.list.domain.usecase

import com.jo.trudoctask.list.domain.repository.IBusinessRepository
import com.jo.trudoctask.list.domain.result.BusinessesListResult
import javax.inject.Inject

/**
 * GetBusinessesListUseCase: getBusinessList to retrieve list from IBusinessRepository.
 *
 * @property repository: get First Page & get Digest List.
 * @see IBusinessRepository
 */
class GetBusinessesListUseCase @Inject constructor(private val repository: IBusinessRepository) {
    /**
     * Retrieve the businesses list using the [IBusinessRepository]
     * @see IBusinessRepository
     *
     * @param location This string indicates the geographic area to be used when searching for businesses.
     * @param keyword Search term, for example "food" or "restaurants".
     * @param limit  Number of business results to return.
     * @param offset Offset the list of returned business results by this amount.
     *
     * @return Instance of [BusinessesListResult] wrapping the list.
     */
    suspend fun getBusinessList(
        location: String = "New York City",
        keyword: String? = null,
        limit: Int = 30,
        offset: Int = 0
    ): BusinessesListResult {
        return repository.getBusinessList(location, keyword, limit, offset)
    }
}