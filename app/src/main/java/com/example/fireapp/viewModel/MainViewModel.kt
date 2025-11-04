package com.example.fireapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.fireapp.data.UiState
import com.example.fireapp.data.UiEvent
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
    val dialogState = _uiState.asStateFlow()

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