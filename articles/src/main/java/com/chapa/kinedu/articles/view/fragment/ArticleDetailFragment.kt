package com.chapa.kinedu.articles.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.chapa.kinedu.api.model.response.ArticleDetailResponse
import com.chapa.kinedu.articles.R
import com.chapa.kinedu.articles.databinding.FragmentArticleDetailBinding
import com.chapa.kinedu.articles.viewModel.ArticleViewModel
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
            requireActivity().runOnUiThread {
                viewBinding.detail.visibility = View.GONE
                viewBinding.loader.visibility = View.VISIBLE
            }
        }

        override fun onNext(t: ArticleDetailResponse?) {
            requireActivity().runOnUiThread {
                viewBinding.text.text = t?.article?.title ?: "ERROR"
            }
        }

        override fun onError(e: Throwable?) {
            requireActivity().runOnUiThread {
                Toast.makeText(this@ArticleDetailFragment.context, "Hubo un error al cargar el articulo...", Toast.LENGTH_LONG).show()
            }
        }

        override fun onComplete() {
            requireActivity().runOnUiThread {
                viewBinding.loader.visibility = View.GONE
                viewBinding.detail.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    this@ArticleDetailFragment.findNavController().popBackStack()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
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
        val articleId = arguments?.getInt("articleId") ?: 0
        articleViewModel.getDetail(articleId).subscribe(detailObserver)
    }

    companion object {
        fun newInstance() = ArticleListFragment()
    }
}