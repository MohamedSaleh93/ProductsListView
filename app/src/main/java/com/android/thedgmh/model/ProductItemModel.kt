package com.android.thedgmh.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by mohamedsaleh on 2/16/19.
 */
open class ProductItemModel(
        @PrimaryKey
        var id: Int = 0,
        var name: String = "",
        var productDescription: String = "",
        var image: ProductImageModel? = null,
        var price: Double = 0.0) : RealmObject(), Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(ProductImageModel::class.java.classLoader),
            parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(productDescription)
        parcel.writeParcelable(image, flags)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductItemModel> {
        override fun createFromParcel(parcel: Parcel): ProductItemModel {
            return ProductItemModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductItemModel?> {
            return arrayOfNulls(size)
        }
    }
}