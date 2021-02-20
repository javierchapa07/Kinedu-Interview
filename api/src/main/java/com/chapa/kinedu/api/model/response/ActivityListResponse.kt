package com.chapa.kinedu.api.model.response

import com.chapa.kinedu.api.model.Activity

data class ActivityListResponse(
    var id : Int,
    var name : String,
    var type : String,
    var activities : Array<Activity>
) : IResponse