package com.android.thedgmh.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by mohamedsaleh on 2/22/19.
 */

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}