package com.chapa.kinedu.activities.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chapa.kinedu.activities.R
import com.chapa.kinedu.activities.databinding.FragmentActivityDetailBinding
import com.chapa.kinedu.activities.viewModel.ActivityViewModel
import com.chapa.kinedu.api.model.response.ActivityDetailResponse
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class ActivityDetailFragment : DaggerFragment() {

    lateinit var viewBinding: FragmentActivityDetailBinding

    @Inject
    lateinit var activityViewModel: ActivityViewModel

    private val detailObserver = object : Observer<ActivityDetailResponse> {
        override fun onSubscribe(d: Disposable?) {
            println("")
        }

        override fun onNext(t: ActivityDetailResponse?) {
            println(t?.activity?.name)
        }

        override fun onError(e: Throwable?) {
            println("")
        }

        override fun onComplete() {
            println("")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_activity_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentActivityDetailBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityViewModel.getDetail(0).subscribe(detailObserver)
    }

    companion object {
        fun newInstance() = ActivityListFragment()
    }
}