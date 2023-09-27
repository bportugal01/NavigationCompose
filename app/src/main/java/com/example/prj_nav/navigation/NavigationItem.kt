package com.example.prj_nav.navigation


import com.example.prj_nav.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.baseline_home_24, "Home")
    object Perfil : NavigationItem("perfil", R.drawable.baseline_account_circle_24, "Perfil")
    object Config : NavigationItem("config", R.drawable.baseline_details_24, "Detalhe")
}

sealed class Screen2(val route: String, var title: String) {
    object Splash : Screen2("splash_screen", "splach")
}