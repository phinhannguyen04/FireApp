package com.example.fireapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.composables.icons.lucide.Flame
import com.composables.icons.lucide.Lucide
import com.example.fireapp.components.Layout
import com.example.fireapp.components.NotificationItem
import com.example.fireapp.data.Notification
import com.example.fireapp.data.UiState
import com.example.fireapp.viewModel.MainViewModel


@Composable
fun NotificationScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel()
) {
    val dialogState by mainViewModel.uiState.collectAsState()
    val notifications by mainViewModel.notifications.collectAsState()

    NotificationScreenContent (
        dialogState = dialogState,
        onShowDialog = { mainViewModel.onShowDialog() },
        onDismissDialog = { mainViewModel.onDismissDialog() },
        onFabClick = { mainViewModel.onFabClick() },
        notifications = notifications
    )
}

@Composable
fun NotificationScreenContent (
    dialogState: UiState,
    onShowDialog: () -> Unit,
    onDismissDialog: () -> Unit,
    onFabClick: () -> Unit,
    notifications: List<Notification> = emptyList()
) {
    Layout (
        showDialog = dialogState.showDialog,
        onFabClick = onFabClick,
        onDismissDialog = onDismissDialog
    ) {innerPadding ->
        LazyColumn (
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) { Text("Cảnh báo", fontSize = 24.sp, fontWeight = FontWeight.Bold) }
            }

            items(notifications) { notification ->
                NotificationItem(
                    cameraName = "Camera 1",
                    icon = Lucide.Flame,
                    iconColor = Color.Red,
                    notification = notification
                )
            }
            item { Button(onClick = onShowDialog) { Text("Turn on Dialog") } }
        }
    }
}



