package com.chapa.kinedu.api.model.response

import com.chapa.kinedu.api.model.Article

data class ArticleListResponse (
    var articles : Array<Article>
) : IResponse