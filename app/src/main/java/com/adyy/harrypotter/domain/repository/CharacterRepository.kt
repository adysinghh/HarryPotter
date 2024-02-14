package com.adyy.harrypotter.domain.repository

import com.adyy.harrypotter.core.commom.Resource
import com.adyy.harrypotter.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters() : Flow<Resource<List<Characters>>>
}