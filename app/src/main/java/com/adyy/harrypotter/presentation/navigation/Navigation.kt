package com.adyy.harrypotter.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adyy.harrypotter.presentation.components.CharacterScreen
import com.adyy.harrypotter.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route ){

        composable(Screen.CharacterScreen.route){
            val CharactersViewModel = hiltViewModel<CharactersViewModel>()
            val charactersState = CharactersViewModel.charactersState.collectAsStateWithLifecycle().value
            CharacterScreen(modifier = Modifier, charactersState =  charactersState)
        }
    }
}
