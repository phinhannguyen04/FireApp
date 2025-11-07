package com.example.fireapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fireapp.screens.HomeScreen
import com.example.fireapp.screens.NotificationScreen



@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost (
        navController = navController,
        startDestination = Route.HomeScreen.path,
        modifier = modifier
    ) {
        composable(Route.HomeScreen.path) {
            HomeScreen(navController)
        }
        composable(Route.NotificationsScreen.path) {
            NotificationScreen(navController)
        }
    }
}