package com.example.fireapp.components

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/*
* composable để hiển thị luồng video từ IP Webcam sử dụng WebView.
*
* @param videoUrl: URL của luồng video từ IP Webcam (ví dụ: "https://google.com")
* @param modifier: Modifier để tùy chỉnh giao diện của WebView.
*/
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun IpWebcamStream(
    videoUrl: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.apply {
                    javaScriptEnabled = true
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    builtInZoomControls = false
                    displayZoomControls = false
                }
                webViewClient = WebViewClient()
                loadUrl(videoUrl)
            }
        },
        update = { webView ->
            webView.loadUrl(videoUrl)
        },
        modifier = modifier
    )
}