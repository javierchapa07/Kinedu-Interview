package com.chapa.kinedu.api.model.response

import com.chapa.kinedu.api.model.Activity
import com.chapa.kinedu.api.model.Article
import com.google.gson.annotations.SerializedName

data class ArticleDetailResponse (
    var article : Article,
    @SerializedName("related_items") var relatedItems : RelatedItems
) : IResponse {
    data class RelatedItems(
        var activities : Array<Activity>,
        var articles : Array<Article>
    )
}