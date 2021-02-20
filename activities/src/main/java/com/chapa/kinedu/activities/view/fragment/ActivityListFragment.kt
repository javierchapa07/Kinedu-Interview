package com.chapa.kinedu.activities.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chapa.kinedu.activities.viewModel.ActivityViewModel
import com.chapa.kinedu.activity.activities.R
import com.chapa.kinedu.activity.activities.databinding.FragmentActivityListBinding
import com.chapa.kinedu.api.model.response.ActivityListResponse
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class ActivityListFragment : DaggerFragment() {

    lateinit var viewBinding: FragmentActivityListBinding

    @Inject
    lateinit var activityViewModel: ActivityViewModel

    private val feedObserver = object : Observer<ActivityListResponse> {
        override fun onSubscribe(d: Disposable?) {
            println("")
        }

        override fun onNext(t: ActivityListResponse?) {
            t?.activities?.forEach {
                println(it.name)
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
        return inflater.inflate(R.layout.fragment_activity_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentActivityListBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityViewModel.getFeed().subscribe(feedObserver)
    }

    companion object {
        fun newInstance() = ActivityListFragment()
    }
}