package com.chapa.kinedu.api.model

import com.google.gson.annotations.SerializedName

data class Article(
    var id : Int,
    var title : String,
    var picture : String,
    var link : String,
    var areaId : Int,
    var body : String,
    var faved : Boolean,
    @SerializedName("short_description") var shortDescription : String
) : IModel