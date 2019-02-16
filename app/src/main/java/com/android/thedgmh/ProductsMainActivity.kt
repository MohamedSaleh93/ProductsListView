package com.android.thedgmh

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.android.thedgmh.adapter.ProductsAdapter
import com.android.thedgmh.model.ProductItemModel
import kotlinx.android.synthetic.main.activity_main.*

class ProductsMainActivity : AppCompatActivity() {

    private val TAG = ProductsMainActivity::class.java.name

    private lateinit var productsViewModel: ProductsViewModel
    private lateinit var productsAdapter: ProductsAdapter
    private val DATA_LOADED = "DATA LOADED"
    private val NO_DATA = "NO DATA"
    private val SERVER_ERROR = "SERVER ERROR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsAdapter = ProductsAdapter(ArrayList<ProductItemModel>())
        val layoutManager = LinearLayoutManager(this)
        productsRV.layoutManager = layoutManager
        productsRV.adapter = productsAdapter

        productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)

        productsViewModel.productsItemsList.observe(this, Observer {
            productsList -> onProductsDataLoaded(productsList)
        })

        productsViewModel.loadingProductsError.observe(this, Observer {
            errorMessage -> onLoadingDataReturnedError(errorMessage)
        })

        swipeToRefreshView.isRefreshing = true
        productsViewModel.getProducts()

        swipeToRefreshView.setOnRefreshListener {
            productsViewModel.getProducts()
        }
    }

    private fun onProductsDataLoaded(productsList: List<ProductItemModel>?) {
        productsAdapter.addItems(productsList)
        productsList?.let {
            if (it.isNotEmpty()) {
                changeViewState(DATA_LOADED)
            } else {
                changeViewState(NO_DATA)
            }
        }
    }

    private fun onLoadingDataReturnedError(errorMessage: String?) {
        Log.e(TAG, "Error while loading products: [$errorMessage]")
        changeViewState(SERVER_ERROR)
    }

    private fun changeViewState(status: String) {
        when(status) {
            DATA_LOADED -> {
                statusTV.visibility = View.GONE
                if (swipeToRefreshView.isRefreshing) {
                    swipeToRefreshView.isRefreshing = false
                }
                productsRV.visibility = View.VISIBLE
            }
            NO_DATA -> {
                statusTV.visibility = View.VISIBLE
                statusTV.text = getString(R.string.no_data)
                if (swipeToRefreshView.isRefreshing) {
                    swipeToRefreshView.isRefreshing = false
                }
                productsRV.visibility = View.GONE
            }
            SERVER_ERROR -> {
                statusTV.visibility = View.VISIBLE
                statusTV.text = getString(R.string.cant_load_data)
                if (swipeToRefreshView.isRefreshing) {
                    swipeToRefreshView.isRefreshing = false
                }
                productsRV.visibility = View.GONE
            }
        }
    }
}
