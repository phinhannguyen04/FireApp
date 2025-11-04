package com.example.firedetection.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fireapp.R
import com.example.fireapp.components.Layout
import com.example.fireapp.components.VideoStreamPlayer
import com.example.fireapp.ui.theme.Purple40
import com.example.fireapp.viewModel.MainViewModel

@Preview
@Composable
fun HomeSreen(
    mainViewModel: MainViewModel = MainViewModel()
) {
    val dialogState by mainViewModel.dialogState.collectAsState()
    Layout (
        showDialog = dialogState.showDialog,
        onFabClick = { mainViewModel.onShowDialog() },
        onDismissDialog = { mainViewModel.onDismissDialog() }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            // ---- Đặt VideoStreamPlayer vào đây ----
            val streamUrl = stringResource(R.string.stream_url) // THAY THẾ BẰNG URL THỰC TẾ
            VideoStreamPlayer(
                modifier = Modifier.fillMaxSize(),
                videoUrl = streamUrl
            )

            // Bạn có thể đặt các thông tin khác đè lên trên video
            Text(
                "Trực tiếp từ Camera 1",
                color = Purple40,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )
        }

    }
}

@Preview
@Composable
fun HowScreenReview() {
    HomeSreen()
}






