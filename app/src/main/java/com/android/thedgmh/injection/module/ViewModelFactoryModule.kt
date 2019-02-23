package com.android.thedgmh.injection.module

import com.android.thedgmh.data.ProductsUseCase
import com.android.thedgmh.data.UseCase
import com.android.thedgmh.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mohamedsaleh on 2/23/19.
 */

@Module
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(productsUseCase: UseCase): ViewModelFactory {
        return ViewModelFactory(productsUseCase)
    }
}