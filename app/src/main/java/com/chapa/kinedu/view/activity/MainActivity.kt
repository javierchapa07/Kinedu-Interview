package com.chapa.kinedu.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.chapa.kinedu.R
import com.chapa.kinedu.databinding.ActivityMainBinding
import com.chapa.kinedu.view.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Picasso.get().load(R.drawable.banner).into(viewBinding.banner, object : Callback {
            override fun onSuccess() {
                viewBinding.banner.translationY = -200f
                viewBinding.banner.animate().translationY(0f).setDuration(2000).start()
            }

            override fun onError(e: Exception?) {}
        })

        viewBinding.viewPager.adapter = SectionsPagerAdapter(this)

        TabLayoutMediator(viewBinding.tabs, viewBinding.viewPager) { tab, position ->
            tab.text = pageTitles[position]
            tab.icon = ContextCompat.getDrawable(this, pageIcons[position])
        }.attach()
    }

    companion object {
        val pageTitles = arrayOf("ARTICLES", "ACTIVITIES")
        val pageIcons = arrayOf(R.drawable.articles, R.drawable.activities)
    }
}