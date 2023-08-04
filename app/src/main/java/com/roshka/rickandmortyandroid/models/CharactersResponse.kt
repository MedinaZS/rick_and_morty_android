package com.roshka.rickandmortyandroid.models

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") var info : Pagination,
    @SerializedName("results") var results: List<Character>,
)

