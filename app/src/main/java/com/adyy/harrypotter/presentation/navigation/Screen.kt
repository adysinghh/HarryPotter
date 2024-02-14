package com.adyy.harrypotter.presentation.navigation

sealed class Screen(val route: String) {
    object CharacterScreen : Screen("character_screen")
}