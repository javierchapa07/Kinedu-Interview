package com.chapa.kinedu.api.model

import com.google.gson.annotations.SerializedName

data class Article(
    var id : Int = 0,
    var name : String = "",
    var title : String = "",
    var picture : String = "",
    var link : String = "",
    var areaId : Int = 0,
    var body : String = "",
    var faved : Boolean = false,
    var type : String = "",
    @SerializedName("min_age")var minAge : Int = 0,
    @SerializedName("max_age")var maxAge : Int = 0,
    @SerializedName("short_description") var shortDescription : String  = ""
) : IModel