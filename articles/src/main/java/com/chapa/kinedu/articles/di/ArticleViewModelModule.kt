package com.chapa.kinedu.articles.di

import com.chapa.kinedu.api.repository.ArticleRepository
import com.chapa.kinedu.articles.viewModel.ArticleViewModel
import dagger.Module
import dagger.Provides

@Module
class ArticleViewModelModule {
    @Provides
    fun provideArticleViewModel(articleRepository: ArticleRepository):
            ArticleViewModel = ArticleViewModel(articleRepository)
}