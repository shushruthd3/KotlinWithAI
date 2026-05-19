package com.example.myapplication.ui

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object Settings : Screen("settings")
    object Maps : Screen("maps")
    object Cart : Screen("cart")
}
