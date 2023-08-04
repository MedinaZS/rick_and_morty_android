package com.roshka.rickandmortyandroid.models

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count") var totalResultados : Int,
    @SerializedName("pages") var totalPaginas : Int,
    @SerializedName("next") var paginaSiguiente : String,
    @SerializedName("prev") var paginaAnterior : String,
)
