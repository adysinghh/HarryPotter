package com.adyy.harrypotter.data.api

import com.adyy.harrypotter.data.dto.CharactersDto
import com.adyy.harrypotter.domain.model.Characters
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters() : List<CharactersDto>
}