package com.chapa.kinedu.activities.util

import android.content.Context
import com.chapa.kinedu.activities.view.adapter.ActivityItem
import com.chapa.kinedu.api.model.Activity

fun List<Activity>.toActivityItem(context : Context, click : (id : Int) -> Unit) :
        List<ActivityItem>{ return this.map { article -> ActivityItem(context, article, click) } }
