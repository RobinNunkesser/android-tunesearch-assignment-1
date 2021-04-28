package de.hshl.isd.tunesearchassignment1

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(val route: String) {
    object Main : Screen("main")
}

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String = Screen.Main.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
    }
}