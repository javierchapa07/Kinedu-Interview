package com.chapa.kinedu.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chapa.kinedu.activities.view.fragment.ActivityContainerFragment
import com.chapa.kinedu.articles.view.fragment.ArticleContainerFragment
import timber.log.Timber

class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa)  {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        Timber.i("Cambia de tab")
        return when (position) {
            0 -> ArticleContainerFragment.newInstance()
            1 -> ActivityContainerFragment.newInstance()
            else -> throw Throwable("No existe fragmento")
        }
    }
}