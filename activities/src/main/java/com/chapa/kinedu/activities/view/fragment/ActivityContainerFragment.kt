package com.chapa.kinedu.activities.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chapa.kinedu.activities.R

class ActivityContainerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_activity_container, container, false)
    }

    companion object {
        fun newInstance() = ActivityContainerFragment()
    }
}