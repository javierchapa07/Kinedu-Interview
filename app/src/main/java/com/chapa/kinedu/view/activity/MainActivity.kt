package com.chapa.kinedu.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chapa.kinedu.databinding.ActivityMainBinding
import com.chapa.kinedu.view.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.viewPager.adapter = SectionsPagerAdapter(this)

        TabLayoutMediator(viewBinding.tabs, viewBinding.viewPager) { tab, position ->
            tab.text = pageTitles[position]
        }.attach()
    }

    companion object {
        val pageTitles = arrayOf("Articulos", "Actividades")
    }
}