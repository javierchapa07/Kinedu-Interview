package com.chapa.kinedu.articles.viewModel

import androidx.lifecycle.ViewModel
import com.chapa.kinedu.api.model.response.ArticleListResponse
import com.chapa.kinedu.api.model.response.ArticleDetailResponse
import com.chapa.kinedu.api.repository.ArticleRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ArticleViewModel @Inject constructor(var articleRepository: ArticleRepository) :
    ViewModel() {

    fun getFeed(): Observable<ArticleListResponse> = Observable.create { emitter ->
        articleRepository.getAll().subscribe { response ->
            emitter.onNext(response)
            emitter.onComplete()
        }
    }

    fun getDetail(id : Int) : Observable<ArticleDetailResponse> = Observable.create { emitter ->
        articleRepository.get(id).subscribe { response ->
            emitter.onNext(response)
            emitter.onComplete()
        }
    }
}