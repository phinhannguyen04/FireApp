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
import com.composables.icons.lucide.Dot
import com.composables.icons.lucide.Flame
import com.composables.icons.lucide.Lucide
import com.example.fireapp.ui.theme.Carol

@Composable
fun NotificationItem(
    cameraName: String = "Camera 1",
    relativeTime: String,
    icon: ImageVector,
    iconColor: Color,
    confidence: String,
    detectionType: String,
    fullDateTime: String
) {
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
                        Text(fullDateTime, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Icon(
                            imageVector = Lucide.Dot,
                            contentDescription = "Dot Icon",
                            modifier = Modifier
                                .padding(horizontal = 2.dp)
                                .size(16.dp),
                            tint = Color.Gray
                        )
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
                        contentDescription = "$detectionType Icon",
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
                            text = confidence,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                        )
                        Text(
                            // Sử dụng tham số
                            detectionType,
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
        relativeTime = "5 phút trước",
        icon = Lucide.Flame,
        iconColor = Color.Red,
        confidence = "95%",
        detectionType = "Lửa",
        fullDateTime = "20/10/2024"
    )
}
