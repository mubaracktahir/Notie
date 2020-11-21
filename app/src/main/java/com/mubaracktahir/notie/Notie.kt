package com.mubaracktahir.notie

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


/**
 * Created by Mubarak Tahir on 11/20/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
@HiltAndroidApp
class Notie : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}