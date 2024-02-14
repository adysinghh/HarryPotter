package com.adyy.harrypotter.domain.usecase

import com.adyy.harrypotter.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val repository: CharacterRepository){

    operator fun invoke() = repository.getAllCharacters()

}