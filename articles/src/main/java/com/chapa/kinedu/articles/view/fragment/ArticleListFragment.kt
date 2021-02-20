package com.chapa.kinedu.articles.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chapa.kinedu.articles.viewModel.ArticleViewModel
import com.chapa.kinedu.articles.R
import com.chapa.kinedu.api.model.response.ArticleListResponse
import com.chapa.kinedu.articles.databinding.FragmentArticleListBinding
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class ArticleListFragment : DaggerFragment() {

    lateinit var viewBinding: FragmentArticleListBinding

    @Inject
    lateinit var activityViewModel: ArticleViewModel

    private val feedObserver = object : Observer<ArticleListResponse> {
        override fun onSubscribe(d: Disposable?) {
            println("")
        }

        override fun onNext(t: ArticleListResponse?) {
            t?.articles?.forEach {
                println(it.title)
            }
        }

        override fun onError(e: Throwable?) {
            println("")
        }

        override fun onComplete() {
            println("")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentArticleListBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityViewModel.getFeed().subscribe(feedObserver)
    }

    companion object {
        fun newInstance() = ArticleListFragment()
    }
}