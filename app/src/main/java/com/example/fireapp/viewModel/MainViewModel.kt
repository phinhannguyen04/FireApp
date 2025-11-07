package com.example.fireapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.fireapp.data.Notification
import com.example.fireapp.data.UiEvent
import com.example.fireapp.data.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    /* _uiEvent gui su kien len chanel */
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    /* _dialogStage quan ly trang thai cua dialog component de dua ra canh bao phat hien dam chay*/
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    /* _notifications quan ly danh sach thong báo mail đã được gửi để người nhận */
    private val _notifications = MutableStateFlow<List<Notification>>(emptyList())
    val notifications = _notifications.asStateFlow()


    init {
        // Tải danh sách thông báo khi ViewModel được tạo (ví dụ)
        loadNotifications()
    }

    /* Hàm loadNotifications() lấy ra danh sách tất cả các email đã được gửi đến clinet */
    private fun loadNotifications() {
        _notifications.value = (1..10).map {
            Notification(
                id = it.toString(),
                timestamp = "2024-06-0$it 12:0${it} PM",
                subject = "Cảnh báo cháy số $it",
                receiver = "",
                detected_objects = listOf("Lửa", "Khói"),
                video_path = "",
                confidence_avg = 0.95,
                snapshot_path = "",
                status = "new"
            )
        }
    }

    /* onShowDialog() chuyen doi trang thai dialog thangh true de hien thi tren man hinh */
    fun onFabClick() {
        _uiEvent.trySend(UiEvent.Dial("114"))
    }

    fun onShowDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                showDialog = true
            )
        }
    }
    /* onDismissDialog() chuyen doi trang thai dialog thangh false de dong hien thi tren man hinh */
    fun onDismissDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                showDialog = false
            )
        }
    }
}