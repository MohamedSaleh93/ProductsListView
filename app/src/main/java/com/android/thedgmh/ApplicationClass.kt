package com.android.thedgmh

import android.app.Application
import io.realm.Realm

/**
 * Created by mohamedsaleh on 2/18/19.
 */
class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}