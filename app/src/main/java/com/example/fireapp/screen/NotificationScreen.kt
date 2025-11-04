package com.example.fireapp.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fireapp.components.Layout
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
                .padding(innerPadding)
        ) {

        }
    }
}
