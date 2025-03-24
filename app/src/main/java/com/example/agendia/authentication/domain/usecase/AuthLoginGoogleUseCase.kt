package com.example.agendia.authentication.domain.usecase

import com.example.agendia.authentication.domain.interfaces.AuthenticationRepository
import javax.inject.Inject

class AuthLoginGoogleUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke():  Result<Unit> =
        authenticationRepository.oneTapLogin()


}