package com.example.trafficlight.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trafficlight.ui.screens.*

object Route {
    const val FirstScreen = "first_screen"
    const val SecondScreen = "second_screen/{carModel}"
}

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.FirstScreen
    ) {
        composable(Route.FirstScreen) {
            FirstScreen(navController)
        }
        composable(
            Route.SecondScreen,
            arguments = listOf(
                navArgument("carModel") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val carModel = backStackEntry.arguments?.getString("carModel") ?: ""
            SecondScreen(carModel)
        }
    }
}
