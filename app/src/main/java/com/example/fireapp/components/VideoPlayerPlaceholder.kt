package com.example.fireapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Video

/**
 * Một Composable giả lập cho VideoStreamPlayer chỉ để sử dụng trong chế độ Preview.
 * Nó không khởi tạo ExoPlayer mà chỉ hiển thị một Box màu đen.
 */
@Composable
fun VideoPlayerPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Lucide.Video,
            contentDescription = "Video Placeholder",
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}
