package com.example.agendia.home.domain.usecase


import com.example.agendia.home.domain.interfaces.IHomeRepository
import com.google.api.services.calendar.model.Event
import javax.inject.Inject

class GetTodayEventsUseCase @Inject constructor(
    private val googleCalendarService: IHomeRepository
) {
    suspend fun invoke() = googleCalendarService.getTodayEvents()
}