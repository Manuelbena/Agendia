package com.example.agendia.authentication


import android.content.Context


sealed interface LoginEvent {
    data class LogIn(val context: Context) : LoginEvent
}