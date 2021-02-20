package com.chapa.kinedu.articles.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chapa.kinedu.articles.viewModel.ArticleViewModel
import com.chapa.kinedu.articles.R
import com.chapa.kinedu.articles.databinding.FragmentArticleDetailBinding
import com.chapa.kinedu.api.model.response.ArticleDetailResponse
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class ArticleDetailFragment : DaggerFragment() {

    lateinit var viewBinding: FragmentArticleDetailBinding

    @Inject
    lateinit var articleViewModel: ArticleViewModel

    private val detailObserver = object : Observer<ArticleDetailResponse> {
        override fun onSubscribe(d: Disposable?) {
            println("")
        }

        override fun onNext(t: ArticleDetailResponse?) {
            println(t?.article?.title)
        }

        override fun onError(e: Throwable?) {
            println("")
        }

        override fun onComplete() {
            println("")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_article_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentArticleDetailBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        articleViewModel.getDetail(0).subscribe(detailObserver)
    }

    companion object {
        fun newInstance() = ArticleListFragment()
    }
}