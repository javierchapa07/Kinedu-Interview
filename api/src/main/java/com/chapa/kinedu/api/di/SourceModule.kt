package com.chapa.kinedu.api.di

import com.chapa.kinedu.api.dao.ActivityDAO
import com.chapa.kinedu.api.dao.ArticleDAO
import com.chapa.kinedu.api.service.ActivityService
import com.chapa.kinedu.api.service.ArticleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class SourceModule {

    @Provides
    @Singleton
    fun provideArticleService(retrofit: Retrofit): ArticleService = retrofit.create(ArticleService::class.java)

    @Provides
    @Singleton
    fun provideActivityService(retrofit: Retrofit): ActivityService = retrofit.create(ActivityService::class.java)

    @Provides
    @Singleton
    fun provideArticleDAO(): ArticleDAO = ArticleDAO()

    @Provides
    @Singleton
    fun provideActivityDAO(): ActivityDAO = ActivityDAO()
}