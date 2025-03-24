package com.example.agendia.util.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {

    protected val tag = this::class.java.name

    fun <T> executeUseCase(
        useCase: suspend () -> T,
        success: (T) -> Unit,
        error: (Throwable) -> Unit = {
            Log.e(tag, useCase.javaClass.name)
        }
    ) {
        viewModelScope.launch {
            try {
                useCase().also { result -> success(result) }
            } catch (t: Throwable) {
                if (t !is SecurityException) error(t)

            }
        }
    }

}