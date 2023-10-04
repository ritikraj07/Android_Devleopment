package com.retrofit

import com.google.gson.annotations.SerializedName

data class AlbumItems(
    var id: Int,
    var userId: Int,
//    @SerializedName("name")  <-- use for change name from title to name
    var title: String
)
