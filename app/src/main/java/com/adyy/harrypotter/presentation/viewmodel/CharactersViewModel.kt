package com.adyy.harrypotter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adyy.harrypotter.core.commom.Resource
import com.adyy.harrypotter.domain.usecase.GetAllCharacterUseCase
import com.adyy.harrypotter.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) : ViewModel() {

    private val _charactersState = MutableStateFlow(CharactersState())
    val charactersState: StateFlow<CharactersState>
        get() = _charactersState


    init {

    }


    //onEach - suspending nature and parallel execution
    private fun getAllCharacter(){
         useCase().onEach {
             when(it){
                 is Resource.Error -> {
                     _charactersState.value = CharactersState().copy(errorMsg = it.msg)
                 }
                 is Resource.Loading -> {
                     _charactersState.value = CharactersState().copy(isLoading = true)
                 }
                 is Resource.Success -> {
                     _charactersState.value = CharactersState().copy(characters = it.data)
                 }
             }

         }.launchIn(viewModelScope)
    }
}