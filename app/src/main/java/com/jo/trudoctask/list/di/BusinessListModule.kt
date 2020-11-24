package com.jo.trudoctask.list.di

import com.jo.trudoctask.list.data.BusinessApi
import com.jo.trudoctask.list.data.BusinessRepository
import com.jo.trudoctask.list.domain.repository.IBusinessRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit


/**
 * Hilt DI Module that use @Provides to provide the following :
 * <ul>
 *     <li>BusinessApi</li>
 * </ul>
 */
@Module
@InstallIn(ActivityComponent::class)
object BusinessListProviderModule {
    @Provides
    fun providesApi(retrofit: Retrofit): BusinessApi {
        return retrofit.create(BusinessApi::class.java)
    }
}


/**
 * Hilt DI Module that use @Binds to provide the implementation of the following interfaces :
 * <ul>
 *     <li>IBusinessRepository</li>
 * </ul> */
@Module
@InstallIn(ActivityComponent::class)
abstract class BusinessListBinderModule {
    @Binds
    abstract fun bindsRepository(repo: BusinessRepository): IBusinessRepository
}