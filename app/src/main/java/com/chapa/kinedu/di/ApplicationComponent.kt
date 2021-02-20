package com.chapa.kinedu.di

import com.chapa.kinedu.MyApplication
import com.chapa.kinedu.activities.di.ActivityViewModelModule
import com.chapa.kinedu.api.di.RepositoryModule
import com.chapa.kinedu.api.di.NetworkModule
import com.chapa.kinedu.api.di.SourceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectBuilder::class,
    ApplicationModule::class,
    ActivityViewModelModule::class,
    RepositoryModule::class,
    SourceModule::class,
    NetworkModule::class])
interface ApplicationComponent : AndroidInjector<MyApplication> {

    override fun inject(app: MyApplication)

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance app: MyApplication): ApplicationComponent
    }
}