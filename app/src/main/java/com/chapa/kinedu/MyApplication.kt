package com.chapa.kinedu

import com.chapa.kinedu.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyApplication : DaggerApplication() {

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        RxJavaPlugins.setErrorHandler(Timber::e)
        Timber.i("Inicia aplicación y se asigna timber como error handler")
    }

    public override fun applicationInjector(): AndroidInjector<MyApplication> = DaggerApplicationComponent.factory().create(
        this
    )

}