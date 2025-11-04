package com.example.fireapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.fireapp.data.DialogState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    /* _dialogStage quan ly trang thai cua dialog component de dua ra canh bao phat hien dam chay*/
    private val _dialogState = MutableStateFlow(DialogState())
    val dialogState = _dialogState.asStateFlow()

    /* onShowDialog() chuyen doi trang thai dialog thangh true de hien thi tren man hinh */
    fun onShowDialog() {
        _dialogState.update { currentState ->
            currentState.copy(
                showDialog = true
            )
        }
    }
    /* onDismissDialog() chuyen doi trang thai dialog thangh false de dong hien thi tren man hinh */
    fun onDismissDialog() {
        _dialogState.update { currentState ->
            currentState.copy(
                showDialog = false
            )
        }
    }
}