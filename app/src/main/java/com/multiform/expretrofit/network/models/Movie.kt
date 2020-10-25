package com.multiform.expretrofit.network.models

import com.google.gson.annotations.SerializedName
import com.multiform.expretrofit.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_movie.*

class Movie(
    posterPath: String,

    @SerializedName("adult")
    var isAdult: Boolean,

    @SerializedName("overview")
    var overview: String?,

    @SerializedName("release_date")
    var releaseDate: String?,

    genreIds: List<Int>,

//    @SerializedName("id")
//    var idR: Int?,

    @SerializedName("original_title")
    var originalTitle: String?,

    @SerializedName("original_language")
    var originalLanguage: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @SerializedName("popularity")
    var popularity: Double?,

    @SerializedName("vote_count")
    var voteCount: Int?,

    @SerializedName("video")
    var isVideo: Boolean?,

    @SerializedName("vote_average")
    var voteAverage: Double?
): Item() {

    @SerializedName("poster_path")
    var posterPath: String? = null
        get() = "https://image.tmdb.org/t/p/w500$field"

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.title.text = title
        viewHolder.description.text = overview
        viewHolder.subtitle.text = releaseDate
        viewHolder.rating.text = voteAverage?.toString()
    }

    override fun getLayout(): Int = R.layout.item_movie

}