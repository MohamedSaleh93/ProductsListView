package com.android.thedgmh.injection.module

import com.android.thedgmh.data.ProductsLocalDataSource
import com.android.thedgmh.data.ProductsRemoteDataSource
import com.android.thedgmh.data.network.ProductsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mohamedsaleh on 2/22/19.
 */
@Module class DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(productsApi: ProductsApi): ProductsRemoteDataSource {
        return ProductsRemoteDataSource(productsApi)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(): ProductsLocalDataSource {
        return ProductsLocalDataSource()
    }
}