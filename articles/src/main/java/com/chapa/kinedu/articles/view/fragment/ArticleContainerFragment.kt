package com.chapa.kinedu.articles.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chapa.kinedu.articles.R

class ArticleContainerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_container, container, false)
    }

    companion object {
        fun newInstance() = ArticleContainerFragment()
    }
}