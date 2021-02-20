package com.chapa.kinedu.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.DaggerApplication

@Module(includes = [AndroidInjectionModule::class])
abstract class ApplicationModule {

    @Binds
    abstract fun bindApplication(app: DaggerApplication): Application

    @Binds
    abstract fun bindAppContext(app: DaggerApplication): Context
}