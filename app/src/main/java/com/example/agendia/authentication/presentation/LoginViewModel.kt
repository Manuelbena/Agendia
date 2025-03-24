package com.example.agendia.authentication.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.agendia.authentication.domain.usecase.AuthLoginGoogleUseCase
import com.example.agendia.util.base.BaseViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authentication: AuthLoginGoogleUseCase
) : BaseViewModel<LoginEvent>() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.LogIn -> {
                executeUseCase(
                    useCase = { authentication.invoke() },
                    success = {
                        state = state.copy(
                            loginStatus = LoginStatus.LOGGED_IN
                        )}
                    ,
                    error = {
                        state = state.copy(
                            loginStatus = LoginStatus.IDLE
                        )
                        // TODO: Mostrar error
                    }
                )
            }
        }
    }

}