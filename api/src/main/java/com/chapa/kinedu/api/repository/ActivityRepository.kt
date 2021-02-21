package com.chapa.kinedu.api.repository

import com.chapa.kinedu.api.dao.ActivityDAO
import com.chapa.kinedu.api.model.response.ActivityDetailResponse
import com.chapa.kinedu.api.model.response.ActivityListResponse
import com.chapa.kinedu.api.service.ActivityService
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject

class ActivityRepository @Inject constructor(var activityService: ActivityService, var activityDAO: ActivityDAO) : IRepository {

    //TODO: implementar logica de guardado local con room

    fun getAll() : Observable<ActivityListResponse> =
        Observable.create { emitter ->
            activityService.getList().subscribe { response ->
                emitter.onNext(response.data)
                emitter.onComplete()
                Timber.i("Se obtiene lista de actividades")
            }
        }

    fun get(id : Int) : Observable<ActivityDetailResponse> =
        Observable.create { emitter ->
            activityService.get(id).subscribe { response ->
                emitter.onNext(response.data)
                emitter.onComplete()
                Timber.i("Se obtiene detalle de actividad")
            }
        }
}