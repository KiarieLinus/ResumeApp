package com.kiarielinus.myresume.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kiarielinus.myresume.ui.presentation.offer.OfferScreen
import com.kiarielinus.myresume.ui.presentation.portfolio.PortfolioScreen
import com.kiarielinus.myresume.ui.presentation.profile.ProfileScreen
import com.kiarielinus.myresume.ui.theme.MyResumeTheme
import com.kiarielinus.myresume.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyResumeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Profile.route
                    ) {
                        composable(route = Screen.Profile.route) {
                            ProfileScreen(navController = navController)
                        }
                        composable(route = Screen.Portfolio.route) {
                            PortfolioScreen(navController = navController)
                        }
                        composable(route = Screen.Offer.route) {
                            OfferScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}