package com.jo.trudoctask.details.di

import com.jo.trudoctask.details.data.BusinessDetailsApi
import com.jo.trudoctask.details.data.BusinessDetailsRepository
import com.jo.trudoctask.details.domain.repository.IBusinessDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object BusinessDetailsProviderModule {
    @Provides
    @ActivityScoped
    fun providesApi(retrofit: Retrofit): BusinessDetailsApi {
        return retrofit.create(BusinessDetailsApi::class.java)
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class BusinessDetailsBinderModule {
    @Binds
    @ActivityScoped
    abstract fun bindsRepository(impl: BusinessDetailsRepository): IBusinessDetailsRepository
}