package com.roshka.rickandmortyandroid.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("status") var status : String,
    @SerializedName("species") var species : String,
    @SerializedName("type") var type : String,
    @SerializedName("gender") var gender : String,
    @SerializedName("image") var image : String,
    @SerializedName("url") var url : String,
)
