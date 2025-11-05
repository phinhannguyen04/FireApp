package com.example.fireapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun FireAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onFabClick: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Cảnh báo cháy!") },
            text = { Text("Phát hiện khói hoặc lửa trong khu vực! Vui lòng sơ tán ngay.") },
            confirmButton = {
                Button(onClick = onFabClick) {
                    Text("Gọi cứu hỏa")
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

@Composable
fun FireVideoDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onCall: () -> Unit,
    videoUrl: String // <<< 2. Thêm URL của video cần phát
) {
    if (show) {
        // 3. Sử dụng Dialog làm nền tảng
        Dialog(onDismissRequest = onDismiss) {
            // 4. Dùng Card để tạo giao diện dialog
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                // 5. Dùng Column để sắp xếp nội dung
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Title
                    Text(
                        text = "Cảnh báo cháy!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    // Video Player
                    // Bạn có thể cần một ảnh thumbnail che lên trong lúc video đang tải
                    VideoStreamPlayer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp), // Giới hạn chiều cao
                        videoUrl = videoUrl
                    )

                    // Text mô tả
                    Text("Phát hiện đối tượng nguy hiểm. Vui lòng kiểm tra và sơ tán nếu cần thiết.")

                    // Các nút hành động
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButton(onClick = onDismiss) {
                            Text("Đóng")
                        }
                        Button(onClick = onCall, modifier = Modifier.padding(
                            start = 8.dp
                        )) {
                            Text("Gọi cứu hỏa")
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Original Dialog")
@Composable
fun FireAlertDialogPreview() {
    FireAlertDialog(show = true, onDismiss = {}, onFabClick = {})
}

// --- BẮT ĐẦU SỬA LỖI PREVIEW ---

@Preview(name = "Video Dialog")
@Composable
fun FireVideoDialogPreview(

) {
    // Chúng ta không gọi trực tiếp FireVideoDialog ở đây nữa
    // Thay vào đó, chúng ta tạo lại cấu trúc của nó và thay thế phần video
    val sampleVideoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    // Mô phỏng lại giao diện của Dialog
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Title
            Text(
                text = "Cảnh báo cháy!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // THAY THẾ VideoStreamPlayer THẬT BẰNG VideoPlayerPlaceholder
            VideoPlayerPlaceholder(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            // Text mô tả
            Text("Phát hiện đối tượng nguy hiểm. Vui lòng kiểm tra và sơ tán nếu cần thiết.")

            // Các nút hành động
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                TextButton(onClick = { }) {
                    Text("Đóng")
                }
                Button(onClick = { }, modifier = Modifier.padding(start = 8.dp)) {
                    Text("Gọi cứu hỏa")
                }
            }
        }
    }
}