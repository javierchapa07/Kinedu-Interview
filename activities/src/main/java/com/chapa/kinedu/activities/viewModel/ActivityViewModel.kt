package com.chapa.kinedu.activities.viewModel

import androidx.lifecycle.ViewModel
import com.chapa.kinedu.api.model.response.ActivityListResponse
import com.chapa.kinedu.api.repository.ActivityRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ActivityViewModel @Inject constructor(var activityRepository: ActivityRepository) :
    ViewModel() {

    fun getFeed(): Observable<ActivityListResponse> = Observable.create { emitter ->
        activityRepository.getAll().subscribe { response ->
            emitter.onNext(response)
            emitter.onComplete()
        }
    }
}