package com.example.fireapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sử dụng tham số
                    Text(cameraName, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Text(relativeTime, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Icon(
                    // Sử dụng tham số
                    imageVector = icon,
                    contentDescription = "$detectionType Icon",
                    modifier = Modifier.size(72.dp),
                    tint = iconColor
                )
                Text(
                    // Sử dụng tham số
                    text = confidence,
                    fontSize = 20.sp,
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
                        .padding(vertical = 4.dp)
                )
            }
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                // Sử dụng tham số
                Text(fullDateTime)
            }
        }

    }
}