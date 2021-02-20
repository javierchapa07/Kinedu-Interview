package com.chapa.kinedu.api.service

import com.chapa.kinedu.api.model.response.ActivityListResponse
import com.chapa.kinedu.api.model.response.ActivityDetailResponse
import com.chapa.kinedu.api.model.response.Response
import com.chapa.kinedu.api.util.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ActivityService : IService {

    @Headers("Authorization: Token token=${Constants.KINEDU_API_TOKEN}")
    @GET("catalogue/activities")
    fun getList(
        @Query("skill_id") skillId : Int = 5,
        @Query("baby_id") babyId : Int = 2064732) :
            Observable<Response<ActivityListResponse>>

    @Headers("Authorization: Token token=${Constants.KINEDU_API_TOKEN}")
    @GET("activities/{activity_id}/")
    fun get(
        @Path("activity_id") activityId : Int,
        @Query("baby_id") babyId : Int = 2064732,
        @Query("locale") locale : String = "en") :
            Observable<Response<ActivityDetailResponse>>
}