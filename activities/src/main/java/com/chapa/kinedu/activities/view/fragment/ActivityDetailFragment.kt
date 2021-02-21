package com.chapa.kinedu.activities.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
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
            requireActivity().runOnUiThread {
                viewBinding.detail.visibility = View.GONE
                viewBinding.loader.visibility = View.VISIBLE
            }
        }

        override fun onNext(t: ActivityDetailResponse?) {
            requireActivity().runOnUiThread {
                viewBinding.text.text = t?.activity?.name ?: "ERROR"
            }
        }

        override fun onError(e: Throwable?) {
            requireActivity().runOnUiThread {
                Toast.makeText(this@ActivityDetailFragment.context, "Hubo un error al cargar la actividad...", Toast.LENGTH_LONG).show()
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
                    this@ActivityDetailFragment.findNavController().popBackStack()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
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
        val id = arguments?.getInt("activityId") ?: 0
        activityViewModel.getDetail(id).subscribe(detailObserver)
    }

    companion object {
        fun newInstance() = ActivityListFragment()
    }
}