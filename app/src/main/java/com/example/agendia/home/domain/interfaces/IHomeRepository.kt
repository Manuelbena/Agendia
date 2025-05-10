package com.example.agendia.home.domain.interfaces

import com.google.api.services.calendar.model.Event


interface IHomeRepository {
    suspend fun getTodayEvents()
}
