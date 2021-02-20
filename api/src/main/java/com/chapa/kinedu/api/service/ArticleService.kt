package com.chapa.kinedu.api.service

import com.chapa.kinedu.api.model.response.ArticleDetailResponse
import com.chapa.kinedu.api.model.response.ArticleListResponse
import com.chapa.kinedu.api.model.response.Response
import com.chapa.kinedu.api.util.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface ArticleService : IService {

    @Headers("Authorization: Token token=${Constants.KINEDU_API_TOKEN}")
    @GET("catalogue/articles")
    fun getList(
        @Query("skill_id") skillId : Int = 5,
        @Query("baby_id") babyId : Int = 2064732) :
            Observable<Response<ArticleListResponse>>

    @Headers("Authorization: Token token=${Constants.KINEDU_API_TOKEN}")
    @GET("articles/{article_id}")
    fun get(@Path("activity_id") activityId : Int) :
            Observable<Response<ArticleDetailResponse>>
}