package com.chapa.kinedu.activities.view.adapter

import android.content.Context
import android.view.View
import com.chapa.kinedu.activities.R
import com.chapa.kinedu.activities.databinding.ItemActivityBinding
import com.chapa.kinedu.api.model.Activity
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem

class ActivityItem(private val context: Context, private val activity: Activity, private val click: (id: Int) -> Unit) : BindableItem<ItemActivityBinding>() {

    override fun bind(viewBinding: ItemActivityBinding, position: Int) {
        Picasso.get().load(activity.thumbnail).into(viewBinding.thumbnail)
        viewBinding.name.text = activity.name
        viewBinding.purpose.text = activity.purpose
        viewBinding.age.text = "Age ${activity.ageGroup}"
        viewBinding.root.setOnClickListener { click(activity.id) }
    }

    override fun getLayout(): Int {
        return R.layout.item_activity
    }

    override fun initializeViewBinding(view: View): ItemActivityBinding {
        return ItemActivityBinding.bind(view)
    }
}