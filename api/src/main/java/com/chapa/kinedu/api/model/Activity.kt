package com.chapa.kinedu.api.model

import com.google.gson.annotations.SerializedName


data class Activity (
    var id : Int,
    var name : String,
    var age : Int,
    @SerializedName("age_group") var AgeGroup : String,
    @SerializedName("materials_description") var materialsDescription : Any,
    @SerializedName("activity_type") var activityType : String,
    @SerializedName("embed_code") var embedCode : String,
    @SerializedName("likes_count") var likesCount : Int,
    @SerializedName("is_holiday") var isHoliday : Boolean,
    @SerializedName("min_age") var minAge : Int,
    var purpose : String,
    var description : String,
    @SerializedName("video_provider_thumbnails") var videoProviderThumbnails : VideoProviderThumbnails,
    @SerializedName("video_urls") var videoURLs : VideoURLs,
    @SerializedName("video_id") var videoId : String,
    @SerializedName("shareable_video_url") var shareableVideoUrl : String,
    @SerializedName("shareable_thumbnail_url") var shareableThumbnailUrl : String,
    @SerializedName("area_id") var areaId : Int,
    var faved : Boolean,
    var rating : Any,
    @SerializedName("overall_rating_avg") var overallRatingAvg : Int,
    @SerializedName("dap_lifes_checked") var dapLifesChecked : Boolean,
    var locked : Boolean,
    var picture : String
) : IModel {
    data class VideoProviderThumbnails(
        var size1 : String,
        var size2 : String,
        var size3 : String,
        var size4 : String,
        var size5 : String,
        var size6 : String)
    data class VideoURLs(
        var size1 : String,
        var size2 : String,
        var size3 : String,
        var size4 : String)
}