package com.example.fireapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Flame
import com.composables.icons.lucide.Lucide
import com.example.fireapp.components.Layout
import com.example.fireapp.components.NotificationItem
import com.example.fireapp.viewModel.MainViewModel

@Preview
@Composable
fun NotificationScreen(
    mainViewModel: MainViewModel = MainViewModel()
) {
    val dialogState by mainViewModel.dialogState.collectAsState()
    Layout(
        showDialog = dialogState.showDialog,
        onFabClick = { mainViewModel.onShowDialog() },
        onDismissDialog = { mainViewModel.onDismissDialog() }
    ) { innerPadding ->
        LazyColumn (
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            item { Row (
                Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) { Text("Cảnh báo", fontSize = 24.sp, fontWeight = FontWeight.Bold) } }

            items(7) {
                NotificationItem(
                    cameraName = "Camera 1",
                    relativeTime = "5 phút trước",
                    icon = Lucide.Flame,
                    iconColor = Color.Red,
                    confidence = "95%",
                    detectionType = "Lửa",
                    fullDateTime = "12:30 20/10/2024"
                )
            }
        }
    }
}



