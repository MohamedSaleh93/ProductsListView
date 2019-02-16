package com.android.thedgmh.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mohamedsaleh on 2/16/19.
 */
data class ProductImageModel(
        var link: String,
        var height: Int,
        var width: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(link)
        parcel.writeInt(height)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductImageModel> {
        override fun createFromParcel(parcel: Parcel): ProductImageModel {
            return ProductImageModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductImageModel?> {
            return arrayOfNulls(size)
        }
    }
}