package com.example.agendia.authentication.domain.interfaces

interface AuthenticationRepository {
    suspend fun oneTapLogin(): Result<Unit>
}