package com.android.thedgmh

import android.app.Application
import com.android.thedgmh.injection.AppComponent
import com.android.thedgmh.injection.DaggerAppComponent
import io.realm.Realm

/**
 * Created by mohamedsaleh on 2/18/19.
 */
class ApplicationClass: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        appComponent = buildComponent()
    }

    private fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }
}