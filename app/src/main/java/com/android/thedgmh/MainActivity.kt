package com.android.thedgmh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.thedgmh.adapter.ProductsAdapter
import com.android.thedgmh.model.ProductImageModel
import com.android.thedgmh.model.ProductItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productsList = mockProductsModel()
        val productsAdapter = ProductsAdapter(productsList)
        val layoutManager = LinearLayoutManager(this)
        productsRV.layoutManager = layoutManager
        productsRV.adapter = productsAdapter
    }

    private fun mockProductsModel(): List<ProductItemModel> {
        val itemsList = ArrayList<ProductItemModel>()
        var imageModel = ProductImageModel("http://dummyimage.com/150x168.png/dddddd/000000", 168, 150)
        var itemModel = ProductItemModel(1, "Gottlieb and Sons", "asfsdf asdfs", imageModel, 489.0)
        itemsList.add(itemModel)

        var imageMode2 = ProductImageModel("http://dummyimage.com/150x162.png/cc0000/ffffff", 162, 150)
        var itemModel2 = ProductItemModel(2, "Stanton, Greenfelder and Conroy", "asfsdf asdfs", imageMode2, 991.0)
        itemsList.add(itemModel2)

        var imageMode3 = ProductImageModel("http://dummyimage.com/150x185.png/5fa2dd/ffffff", 185, 150)
        var itemModel3 = ProductItemModel(3, "Beatty and Sons", "asfsdf asdfs", imageMode3, 88.0)
        itemsList.add(itemModel3)

        var imageMode4 = ProductImageModel("http://dummyimage.com/150x174.png/5fa2dd/ffffff", 174, 150)
        var itemModel4 = ProductItemModel(4, "Welch-Bogan", "asfsdf asdfs", imageMode4, 478.0)
        itemsList.add(itemModel4)

        var imageMode5 = ProductImageModel("http://dummyimage.com/150x198.png/5fa2dd/ffffff", 198, 150)
        var itemModel5 = ProductItemModel(5, "Swaniawski-Metz", "asfsdf asdfs", imageMode5, 926.0)
        itemsList.add(itemModel5)

        var imageMode6 = ProductImageModel("http://dummyimage.com/150x166.png/dddddd/000000", 166, 150)
        var itemModel6 = ProductItemModel(6, "Witting Group", "asfsdf asdfs", imageMode6, 552.0)
        itemsList.add(itemModel6)

        var imageMode7 = ProductImageModel("http://dummyimage.com/150x199.png/dddddd/000000", 199, 150)
        var itemModel7 = ProductItemModel(7, "Medhurst-Huels", "asfsdf asdfs", imageMode7, 153.0)
        itemsList.add(itemModel7)

        var imageMode8 = ProductImageModel("http://dummyimage.com/150x178.png/5fa2dd/ffffff", 178, 150)
        var itemModel8 = ProductItemModel(8, "Ondricka-Lockman", "asfsdf asdfs", imageMode8, 742.0)
        itemsList.add(itemModel8)

        var imageMode9 = ProductImageModel("http://dummyimage.com/150x193.png/ff4444/ffffff", 193, 150)
        var itemModel9 = ProductItemModel(9, "O'Connell, Dietrich and McGlynn", "asfsdf asdfs", imageMode9, 478.0)
        itemsList.add(itemModel9)

        var imageMode10 = ProductImageModel("http://dummyimage.com/150x187.png/5fa2dd/ffffff", 187, 150)
        var itemModel10 = ProductItemModel(10, "Bogisich Group", "asfsdf asdfs", imageMode10, 109.0)
        itemsList.add(itemModel10)

        return itemsList
    }
}
