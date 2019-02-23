package com.android.thedgmh.injection.module

import com.android.thedgmh.data.ProductsLocalDataSource
import com.android.thedgmh.data.ProductsRemoteDataSource
import com.android.thedgmh.data.ProductsUseCase
import com.android.thedgmh.data.UseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mohamedsaleh on 2/23/19.
 */

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideProductsUseCase(remoteDataSource: ProductsRemoteDataSource, localDataSource: ProductsLocalDataSource): UseCase {
        return ProductsUseCase(remoteDataSource, localDataSource)
    }
}