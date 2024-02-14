package com.adyy.harrypotter.presentation.state

import com.adyy.harrypotter.core.commom.Resource
import com.adyy.harrypotter.domain.model.Characters

data class CharactersState(
    val characters: List<Characters> ? = emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)