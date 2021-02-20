package com.chapa.kinedu

import com.chapa.kinedu.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import timber.log.Timber

class MyApplication : DaggerApplication() {

    init {
        RxJavaPlugins.setErrorHandler(Timber::e)
    }

    public override fun applicationInjector(): AndroidInjector<MyApplication> = DaggerApplicationComponent.factory().create(this)

}