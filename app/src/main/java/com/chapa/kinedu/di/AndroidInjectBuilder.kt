package com.chapa.kinedu.di

import com.chapa.kinedu.activities.di.ActivityViewModelModule
import com.chapa.kinedu.activities.view.fragment.ActivityDetailFragment
import com.chapa.kinedu.activities.view.fragment.ActivityListFragment
import com.chapa.kinedu.articles.view.fragment.ArticleListFragment
import com.chapa.kinedu.articles.di.ArticleViewModelModule
import com.chapa.kinedu.articles.view.fragment.ArticleDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectBuilder {

    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    abstract fun bindActivityListFragment() : ActivityListFragment

    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    abstract fun bindActivityDetailFragment() : ActivityDetailFragment

    @ContributesAndroidInjector(modules = [ArticleViewModelModule::class])
    abstract fun bindArticleListFragment() : ArticleListFragment

    @ContributesAndroidInjector(modules = [ArticleViewModelModule::class])
    abstract fun bindArticleDetailFragment() : ArticleDetailFragment
}