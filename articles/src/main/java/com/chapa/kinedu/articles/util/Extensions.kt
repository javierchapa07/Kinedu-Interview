package com.chapa.kinedu.articles.util

import android.content.Context
import com.chapa.kinedu.api.model.Article
import com.chapa.kinedu.articles.view.adapter.ArticleItem

fun List<Article>.toArticleItem(context : Context, click : (id : Int) -> Unit) :
        List<ArticleItem>{ return this.map { article -> ArticleItem(context, article, click) } }