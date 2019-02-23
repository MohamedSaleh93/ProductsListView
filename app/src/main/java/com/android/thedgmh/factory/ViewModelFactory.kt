package com.android.thedgmh.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.thedgmh.ProductsViewModel
import com.android.thedgmh.data.UseCase
import javax.inject.Inject

/**
 * Created by mohamedsaleh on 2/23/19.
 * Factory class for generating the required view models
 */
class ViewModelFactory @Inject constructor(private var productsUseCase: UseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(productsUseCase) as T
    }
}