package com.chapa.kinedu.articles.view.adapter

import android.content.Context
import android.view.View
import com.chapa.kinedu.api.model.Article
import com.chapa.kinedu.articles.R
import com.chapa.kinedu.articles.databinding.ItemArticleBinding
import com.xwray.groupie.viewbinding.BindableItem


class ArticleItem(private val context: Context, private val article: Article, private val click : (id : Int) -> Unit) : BindableItem<ItemArticleBinding>() {

    override fun bind(viewBinding: ItemArticleBinding, position: Int) {
        viewBinding.text.text = article.name
        viewBinding.root.setOnClickListener { click(article.id) }
    }

    override fun getLayout(): Int {
        return R.layout.item_article
    }

    override fun initializeViewBinding(view: View): ItemArticleBinding {
        return ItemArticleBinding.bind(view)
    }

}