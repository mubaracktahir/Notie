package com.mubaracktahir.notie

import android.app.Application
import timber.log.Timber


/**
 * Created by Mubarak Tahir on 11/20/2020.
 * Mubby inc
 * mubarack.tahirr@gmail.com
 */
class Notie : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}