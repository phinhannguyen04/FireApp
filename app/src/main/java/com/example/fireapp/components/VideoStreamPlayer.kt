package com.example.fireapp.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoStreamPlayer(
    modifier: Modifier = Modifier,
    videoUrl: String
) {
    val context = LocalContext.current

    // Khởi tạo lại ExoPlayer khi videoUrl thay đổi
    val exoPlayer = remember(videoUrl) { // <--- Key là videoUrl
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUrl)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }

    // Quản lý vòng đời của player một cách chính xác
    // DisposableEffect sẽ chạy lại mỗi khi exoPlayer thay đổi
    DisposableEffect(exoPlayer) { // <--- Key BẮT BUỘC phải là exoPlayer
        onDispose {
            // Giải phóng tài nguyên khi Composable bị hủy HOẶC khi exoPlayer được tạo lại
            exoPlayer.release()
        }
    }

    // Sử dụng AndroidView để hiển thị PlayerView.
    // `update` block sẽ được gọi khi exoPlayer thay đổi.
    AndroidView(
        modifier = modifier,
        factory = {
            PlayerView(it).apply {
                player = exoPlayer
                useController = false
            }
        },
        update = {
            // Đảm bảo PlayerView sử dụng instance ExoPlayer mới nhất
            it.player = exoPlayer
        }
    )
}
