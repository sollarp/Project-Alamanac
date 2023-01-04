package com.example.call_mapbox_api.di

import com.example.call_mapbox_api.data.EvPointLocalDataSource
import com.example.call_mapbox_api.data.EvPointRemoteDataSource
import com.example.call_mapbox_api.data.IEvPointLocalDataSource
import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.domain.SearchListUseCase
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class LoggingDatabaseModule {

    @Singleton
    @Binds
    abstract fun bindSearchListUseCase(impl: SearchListUseCase): ISearchListUseCase

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(impl: EvPointRemoteDataSource): IEvPointRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(impl: EvPointLocalDataSource): IEvPointLocalDataSource
}