package com.chapa.kinedu.activities.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chapa.kinedu.activities.R
import com.chapa.kinedu.activities.databinding.FragmentActivityListBinding
import com.chapa.kinedu.activities.util.toActivityItem
import com.chapa.kinedu.activities.viewModel.ActivityViewModel
import com.chapa.kinedu.api.model.response.ActivityListResponse
import com.xwray.groupie.GroupieAdapter
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

class ActivityListFragment : DaggerFragment() {

    private lateinit var viewBinding: FragmentActivityListBinding
    private var groupAdapter : GroupieAdapter = GroupieAdapter()

    @Inject
    lateinit var activityViewModel: ActivityViewModel

    private val feedObserver = object : Observer<ActivityListResponse> {
        override fun onSubscribe(d: Disposable?) {
            requireActivity().runOnUiThread {
                viewBinding.recyclerView.visibility = View.GONE
                viewBinding.loader.visibility = View.VISIBLE
            }
        }

        override fun onNext(t: ActivityListResponse?) {
            val list = t?.activities?.toList()
            if (list != null) {
                requireActivity().runOnUiThread {
                    groupAdapter.clear()
                    groupAdapter.addAll(list.toActivityItem(this@ActivityListFragment.requireContext()) { activityId ->
                        this@ActivityListFragment.findNavController().navigate(R.id.activityDetailFragment, Bundle().apply {
                            putInt("activityId", activityId)
                        })
                    })
                }
            }
        }

        override fun onError(e: Throwable?) {
            requireActivity().runOnUiThread {
                Toast.makeText(this@ActivityListFragment.context, "Hubo un error al cargar actividades...", Toast.LENGTH_LONG).show()
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
        Timber.i("Se crea vista de lista de actividades")
        return inflater.inflate(R.layout.fragment_activity_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentActivityListBinding.bind(view)
        viewBinding.recyclerView.adapter = groupAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        activityViewModel.getFeed().subscribe(feedObserver)
    }

    companion object {
        fun newInstance() = ActivityListFragment()
    }
}