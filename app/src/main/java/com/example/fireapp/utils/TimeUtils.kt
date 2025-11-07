package com.example.fireapp.utils

import android.text.format.DateUtils
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Chuyển đổi một chuỗi thời gian có định dạng "dd/MM/yyyy HH:mm"
 * thành một chuỗi thời gian tương đối (ví dụ: "5 phút trước").
 *
 * @param timestamp Chuỗi thời gian đầu vào.
 * @return Chuỗi thời gian tương đối.
 */
@Composable
fun rememberFormattedTimestamp(timestamp: String): String {
    // remember sẽ giúp chúng ta không cần tính toán lại ở mỗi lần recomposition
    // trừ khi timestamp thay đổi.
    return remember(timestamp) {
        // 1. Định nghĩa định dạng của chuỗi timestamp đầu vào
        val inputFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

        try {
            // 2. Phân tích chuỗi thành một đối tượng Date
            val date = inputFormat.parse(timestamp) ?: return@remember ""

            // 3. Lấy thời gian hiện tại (dưới dạng mili giây)
            val now = System.currentTimeMillis()

            // 4. Sử dụng DateUtils để tạo chuỗi thời gian tương đối
            DateUtils.getRelativeTimeSpanString(
                date.time, // Thời gian của thông báo (mili giây)
                now,       // Thời gian hiện tại (mili giây)
                DateUtils.MINUTE_IN_MILLIS // Độ chính xác tối thiểu (hiển thị "0 phút trước" thay vì "vừa xong")
            ).toString()

        } catch (e: Exception) {
            // Nếu có lỗi parse, trả về chuỗi gốc để tránh crash app
            // e.printStackTrace() // có thể log lỗi để debug
            timestamp
        }
    }
}
