package com.adyy.harrypotter.data.mapper

import com.adyy.harrypotter.data.dto.CharactersDto
import com.adyy.harrypotter.domain.model.Characters

fun CharactersDto.toDomainCharacter() : Characters {
    return  Characters(actor, id, image, name)
}