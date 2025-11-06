package com.example.fireapp.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.fireapp.R

@Composable
fun Layout(
    showDialog: Boolean,
    onFabClick: () -> Unit,
    onDismissDialog: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {

    FireVideoDialog(
        show = showDialog,
        onDismiss = onDismissDialog,
        onCall = onFabClick,
        videoUrl = stringResource(R.string.api_video_test)
    )

    content(PaddingValues())

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