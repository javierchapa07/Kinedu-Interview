package com.chapa.kinedu.api.repository

import com.chapa.kinedu.api.dao.ArticleDAO
import com.chapa.kinedu.api.model.response.ArticleDetailResponse
import com.chapa.kinedu.api.model.response.ArticleListResponse
import com.chapa.kinedu.api.service.ArticleService
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject

class ArticleRepository @Inject constructor(var articleService: ArticleService, var articleDAO: ArticleDAO) : IRepository {

    //TODO: implementar logica de guardado local con room

    fun getAll() : Observable<ArticleListResponse> =
        Observable.create { emitter ->
            articleService.getList().subscribe { response ->
                emitter.onNext(response.data)
                emitter.onComplete()
                Timber.i("Se obtiene lista de articulos")
            }
    }

    fun get(id : Int) : Observable<ArticleDetailResponse> =
    Observable.create { emitter ->
        articleService.get(id).subscribe { response ->
            emitter.onNext(response.data)
            emitter.onComplete()
            Timber.i("Se obtiene detalle de articulo")
        }
    }
}