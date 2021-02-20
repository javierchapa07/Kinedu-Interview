package com.chapa.kinedu.api.model.response

import com.google.gson.annotations.SerializedName

data class Response <T : IResponse> (var data : T, var meta : Meta) {
    data class Meta(
        var page : Int,
        @SerializedName("per_page") var perPage : Int,
        @SerializedName("total_pages") var totalPages : Int,
        var total : Int
    )
}