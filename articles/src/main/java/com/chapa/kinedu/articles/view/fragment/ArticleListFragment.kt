package com.chapa.kinedu.articles.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chapa.kinedu.api.model.response.ArticleListResponse
import com.chapa.kinedu.articles.R
import com.chapa.kinedu.articles.databinding.FragmentArticleListBinding
import com.chapa.kinedu.articles.util.toArticleItem
import com.chapa.kinedu.articles.viewModel.ArticleViewModel
import com.xwray.groupie.GroupieAdapter
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

class ArticleListFragment : DaggerFragment() {

    private lateinit var viewBinding: FragmentArticleListBinding
    private var groupAdapter : GroupieAdapter = GroupieAdapter()

    @Inject
    lateinit var articleViewModel : ArticleViewModel

    private val feedObserver = object : Observer<ArticleListResponse> {
        override fun onSubscribe(d: Disposable?) {
            requireActivity().runOnUiThread {
                viewBinding.recyclerView.visibility = View.GONE
                viewBinding.loader.visibility = View.VISIBLE
            }
        }

        override fun onNext(t: ArticleListResponse?) {
            val list = t?.articles?.toList()
            if (list != null) {
                requireActivity().runOnUiThread {
                    groupAdapter.clear()
                    groupAdapter.addAll(list.toArticleItem(this@ArticleListFragment.requireContext()) { articleId ->
                        this@ArticleListFragment.findNavController().navigate(R.id.articleDetailFragment, Bundle().apply {
                            putInt("articleId", articleId)
                        })
                    })
                }
            }
        }

        override fun onError(e: Throwable?) {
            requireActivity().runOnUiThread {
                Toast.makeText(this@ArticleListFragment.context, "Hubo un error al cargar articulos...", Toast.LENGTH_LONG).show()
            }
        }

        override fun onComplete() {
            requireActivity().runOnUiThread {
                viewBinding.loader.visibility = View.GONE
                viewBinding.recyclerView.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Timber.i("Se crea vista de lista de articulos")
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentArticleListBinding.bind(view)
        viewBinding.recyclerView.adapter = groupAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        articleViewModel.getFeed().subscribe(feedObserver)
    }

    companion object {
        fun newInstance() = ArticleListFragment()
    }
}