package com.kiarielinus.myresume.utils

sealed class Screen(val route: String){
    object Profile: Screen("profile")
    object Offer: Screen("offer")
    object Portfolio: Screen("portfolio")
}
