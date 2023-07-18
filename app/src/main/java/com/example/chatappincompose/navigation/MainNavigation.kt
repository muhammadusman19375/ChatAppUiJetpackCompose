package com.example.chatappincompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatappincompose.screens.ChatScreen
import com.example.chatappincompose.screens.HomeScreen
import com.example.chatappincompose.screens.StartScreen

@Composable
fun MainNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = NavGraph.StartScreen.route) {
        composable(route = NavGraph.StartScreen.route) {
            StartScreen(navHostController)
        }
        composable(route = NavGraph.HomeScreen.route) {
            HomeScreen(navHostController)
        }
        composable(route = NavGraph.ChatScreen.route,
            arguments = listOf(navArgument("personData") { type = NavType.StringType })) {
            it.arguments?.getString("personData")?.let { userData ->
                ChatScreen(userData)
            }
        }
    }
}