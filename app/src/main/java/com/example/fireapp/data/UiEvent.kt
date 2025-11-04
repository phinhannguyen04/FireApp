package com.example.fireapp.data

/* Class dung 1 lan */
sealed class UiEvent {
    data class Dial(val phoneNumber: String): UiEvent()
}