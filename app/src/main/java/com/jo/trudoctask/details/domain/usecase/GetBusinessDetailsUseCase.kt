package com.jo.trudoctask.details.domain.usecase

import com.jo.trudoctask.details.domain.repository.IBusinessDetailsRepository
import com.jo.trudoctask.details.domain.result.BusinessDetailsResult
import javax.inject.Inject

class GetBusinessDetailsUseCase @Inject constructor(private val repository: IBusinessDetailsRepository) {
    suspend fun execute(input: GetBusinessDetailsUseCaseInput): BusinessDetailsResult {
        return repository.getBusinessDetails(input.id)
    }
}

data class GetBusinessDetailsUseCaseInput(val id: String)