package com.example.fireapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Flame
import com.composables.icons.lucide.Lucide
import com.example.fireapp.data.Notification
import com.example.fireapp.ui.theme.Carol
import com.example.fireapp.utils.rememberFormattedTimestamp

@Composable
fun NotificationItem(
    cameraName: String = "Camera 1",
    icon: ImageVector,
    iconColor: Color,
    notification: Notification
) {
    /* Chuyen doi kieu du lieu phut, gio, ngay, thang, nam */
    val relativeTime = rememberFormattedTimestamp(timestamp = notification.timestamp)

    Row (Modifier
        .fillMaxWidth()
    ) {

        Card (
            Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column (
                Modifier
                    .fillMaxWidth()
                    .background(color = Carol.copy(alpha = 0.4f)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sử dụng tham số
                    Text(cameraName, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Row (horizontalArrangement = Arrangement.Center) {
                        Text(relativeTime, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        // Sử dụng tham số
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(72.dp),
                        tint = iconColor
                    )
                    Column (
                        Modifier
                            .wrapContentSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            // Sử dụng tham số
                            text = notification.confidence_avg.toString(),
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                        )
                        Text(
                            // Sử dụng tham số
                            notification.detected_objects.joinToString(", "),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                    }
                }

            }

        }

    }
}

@Preview
@Composable
fun NotificationItemPreview() {
    NotificationItem(
        cameraName = "Camera 1",
        icon = Lucide.Flame,
        iconColor = Color.Red,

        notification = Notification(
            id = "1",
            timestamp = "20/10/2025 14:30",
            detected_objects = listOf("Lửa", "Khói"),
            confidence_avg = 0.95,
            video_path = "https://example.com/video.mp4",
            subject = "ff",
            snapshot_path ="ss",
            receiver = "rr",
            status = "new"
        )
    )
}

