package com.example.fireapp.screens // <<< 1. SỬA LẠI PACKAGE

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.fireapp.R
import com.example.fireapp.components.IpWebcamStream
import com.example.fireapp.components.Layout
import com.example.fireapp.components.VideoPlayerPlaceholder
import com.example.fireapp.data.UiEvent
import com.example.fireapp.data.UiState
import com.example.fireapp.ui.theme.Purple40
import com.example.fireapp.viewModel.MainViewModel


@Composable
fun HomeScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = viewModel()
) {
    // ViewModel giờ đây quản lý một UiState chung
    val uiState by mainViewModel.uiState.collectAsState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    /* Chờ các sự kiện xuất hiện */
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
            mainViewModel.uiEvent.collect { event ->
                when (event) {
                    is UiEvent.Dial -> {
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:${event.phoneNumber}")
                        }
                        context.startActivity(intent)
                    }
                }
            }
        }
    }

    HomeScreenContent(
        uiState = uiState, // <<< Truyền xuống UiState
        onShowDialog = { mainViewModel.onShowDialog() },
        onDismissDialog = { mainViewModel.onDismissDialog() },
        onFabClick = { mainViewModel.onFabClick() },
        isRealPlayer = true
    )
}

@Composable
fun HomeScreenContent(
    uiState: UiState, // <<< 2. SỬA LẠI THAM SỐ THÀNH UiState
    onShowDialog: () -> Unit,
    onDismissDialog: () -> Unit,
    onFabClick: () -> Unit,
    isRealPlayer: Boolean
) {
    Layout (
        showDialog = uiState.showDialog, // Đọc từ UiState
        onFabClick = onFabClick,
        onDismissDialog = onDismissDialog
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Lấy đường dẫn IP stream từ strings.xml
            val streamUrl = stringResource(R.string.local_stream_ip)

            if (isRealPlayer) {
                // SỬ DỤNG COMPOSABLE MỚI CỦA BẠN
                IpWebcamStream(
                    videoUrl = "http://" +streamUrl + "/browserfs.html",
                    modifier = Modifier.wrapContentSize()
                )
            } else {
                // Chỉ dùng trong Preview để không bị crash
                VideoPlayerPlaceholder(modifier = Modifier.fillMaxSize())
            }

            Text(
                "Trực tiếp từ Camera IP " + streamUrl,
                color = Purple40,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )

            Text(
                "Trực tiếp từ Camera IP",
                color = Purple40,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )
            // Button(onClick = onShowDialog) { Text("Turn on Dialog") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        uiState = UiState(showDialog = false),
        onShowDialog = {},
        onDismissDialog = {},
        onFabClick = {},
        isRealPlayer = false
    )
}
