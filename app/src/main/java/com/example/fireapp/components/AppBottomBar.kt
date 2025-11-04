package com.example.fireapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fireapp.ui.theme.Purple40

@Composable
fun AppBottomBar() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Purple40)
            .height(64.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(icon = Icons.Filled.Home, onClick = { })
        BottomBarItem(icon = Icons.Filled.List, onClick = {  })
        BottomBarItem(icon = Icons.Filled.Notifications, onClick = {  })
    }
}