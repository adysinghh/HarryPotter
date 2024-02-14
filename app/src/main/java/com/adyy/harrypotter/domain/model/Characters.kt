package com.adyy.harrypotter.domain.model

import com.google.gson.annotations.SerializedName

data class Characters(
    val actor: String,
    val id: String,
    val image: String,
    val name: String,
)