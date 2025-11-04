package com.example.fireapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fireapp.ui.theme.Purple40
import com.example.fireapp.ui.theme.Purple80

@Composable
fun Layout(
    showDialog: Boolean,
    onFabClick: () -> Unit,
    onDismissDialog: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            IconButton(
                onClick = onFabClick,
                modifier = Modifier
                    .size(64.dp)
                    .background(color = Purple80, shape = CircleShape)
            ) { Icon(Icons.Filled.Call, contentDescription = null, tint = Purple40, modifier = Modifier.size(42.dp) ) }
        },
        bottomBar = { AppBottomBar() }
    ) { innerPadding ->

        FireAlertDialog(
            show = showDialog,
            onDismiss = onDismissDialog,
            onConfirm = onDismissDialog
        )

        content(innerPadding)
    }
}

@Preview
@Composable
fun LayoutPreview() {
    Layout(
        showDialog = false,
        onFabClick = {},
        onDismissDialog = {}
    ) { innerPadding ->  }
}