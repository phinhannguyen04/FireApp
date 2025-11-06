package com.example.fireapp.navigation

import androidx.navigation.NamedNavArgument

sealed class Route (
    val path: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    // Define your routes here
    data object HomeScreen : Route("home")
    data object NotificationsScreen : Route("notifications")
//    data object NotificationsScreen : Route(
//        "notifications",
//        listOf(navArgument("id") { nullable = true })
//    ) {
//        // Hàm này giúp tạo đường dẫn hoàn chỉnh một cách an toàn
//        // Ví dụ: buildRoute("abc-123") -> "notification_detail/abc-123"
//        fun buildRoute(notificationId: String): String {
//            return "notification_detail/$notificationId"
//        }
//    }
}