package com.example.fireapp.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun FireAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Cảnh báo cháy!") },
            text = { Text("Phát hiện khói hoặc lửa trong khu vực! Vui lòng sơ tán ngay.") },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text("Xác nhận")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Đóng")
                }
            }
        )
    }
}