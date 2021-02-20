package com.chapa.kinedu.api.di

import com.chapa.kinedu.api.dao.ActivityDAO
import com.chapa.kinedu.api.dao.ArticleDAO
import com.chapa.kinedu.api.repository.ActivityRepository
import com.chapa.kinedu.api.repository.ArticleRepository
import com.chapa.kinedu.api.service.ActivityService
import com.chapa.kinedu.api.service.ArticleService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//TODO: Implementar componentes locales para mi scope, y que el modulo trabaje por si solo

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideArticleRepository(articleService: ArticleService, articleDAO: ArticleDAO): ArticleRepository = ArticleRepository(articleService, articleDAO)

    @Provides
    @Singleton
    fun provideActivityRepository(activityService: ActivityService, activityDAO: ActivityDAO): ActivityRepository = ActivityRepository(activityService, activityDAO)
}