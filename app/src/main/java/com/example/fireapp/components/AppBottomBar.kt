package com.example.fireapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fireapp.navigation.Route

@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    /* Lay route hien tai */
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar (){
        NavigationBarItem(
            selected = currentRoute == Route.HomeScreen.path,
            onClick = {
                navController.navigate(Route.HomeScreen.path) {
                    launchSingleTop = true
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                } },
            icon = { Icon(imageVector = Icons.Filled.Home,  contentDescription = null) },
            label = { Text("Trang chủ") }
        )

        NavigationBarItem(
            selected = currentRoute == Route.NotificationsScreen.path,
            onClick = {
                navController.navigate(Route.NotificationsScreen.path) {
                    launchSingleTop = true
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                } },
            icon = { Icon(imageVector = Icons.Filled.Warning, contentDescription = null) },
            label = { Text("Cảnh báo") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomBarPreview() {
    // 1. Tạo một NavController giả cho Preview
    val navController = rememberNavController()

    // 2. Gọi AppBottomBar và truyền NavController giả vào
    AppBottomBar(navController = navController)
}