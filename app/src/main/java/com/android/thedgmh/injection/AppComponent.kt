package com.android.thedgmh.injection

import com.android.thedgmh.ProductsMainActivity
import com.android.thedgmh.injection.module.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mohamedsaleh on 2/22/19.
 */

@Singleton
@Component (modules = arrayOf(NetworkModule::class, AppModule::class,
        DataSourceModule::class, UseCaseModule::class, ViewModelFactoryModule::class))
interface AppComponent {
    fun inject(productsMainActivity: ProductsMainActivity)
}