package com.example.fireapp.data

data class UiState (
    val showDialog: Boolean = false
)

/* Một đối tượng email chứa các thuộc tính là nội dung được gửi đến cilent */
data class Notification(
    val id: String,
    val timestamp: String,
    val subject: String,
    val receiver: String,
    val detected_objects: List<String>,
    val video_path: String,
    val confidence_avg: Double,
    val snapshot_path: String,
    val status: String
)


