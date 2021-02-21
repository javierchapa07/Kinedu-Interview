package com.chapa.kinedu.api.model

import com.google.gson.annotations.SerializedName


data class Activity (
    var id : Int = 0,
    var name : String = "",
    var age : Int = 0,
    @SerializedName("age_group") var ageGroup : String = "",
    @SerializedName("materials_description") var materialsDescription : Any? = null,
    @SerializedName("activity_type") var activityType : String = "",
    @SerializedName("embed_code") var embedCode : String = "",
    @SerializedName("likes_count") var likesCount : Int = 0,
    @SerializedName("is_holiday") var isHoliday : Boolean = false,
    @SerializedName("min_age") var minAge : Int = 0,
    var purpose : String = "",
    var description : String = "",
    var thumbnail : String = "",
    @SerializedName("active_milestones") var activeMilestones : Int = 0,
    @SerializedName("completed_milestones") var completedMilestones : Int = 0,
    @SerializedName("domain_id") var domainId : Int = 0,
    @SerializedName("video_provider_thumbnails") var videoProviderThumbnails : VideoProviderThumbnails? = null,
    @SerializedName("video_urls") var videoURLs : VideoURLs? = null,
    @SerializedName("video_id") var videoId : String= "",
    @SerializedName("shareable_video_url") var shareableVideoUrl : String = "",
    @SerializedName("shareable_thumbnail_url") var shareableThumbnailUrl : String = "",
    @SerializedName("area_id") var areaId : Int = 0,
    var faved : Boolean = false,
    var rating : Any? = null,
    @SerializedName("overall_rating_avg") var overallRatingAvg : Int = 0,
    @SerializedName("dap_lifes_checked") var dapLifesChecked : Boolean = false,
    var locked : Boolean = false,
    var picture : String = ""
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