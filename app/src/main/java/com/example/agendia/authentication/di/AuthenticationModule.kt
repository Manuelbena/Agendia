package com.example.agendia.authentication.di

import android.content.Context
import com.example.agendia.authentication.data.repository.FirebaseAuthentificationRepository
import com.example.agendia.authentication.domain.interfaces.AuthenticationRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {
    @Provides
    @Singleton
    fun provideAuthenticationRepository(@ApplicationContext context: Context): AuthenticationRepository {
        return FirebaseAuthentificationRepository(context)
    }
}