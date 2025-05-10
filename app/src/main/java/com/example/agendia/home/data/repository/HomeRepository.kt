package com.example.agendia.home.data.repository



import android.content.Context

import com.example.agendia.home.domain.interfaces.IHomeRepository

import com.google.api.services.calendar.Calendar

import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val calendarService: Calendar,
    private val context: Context
) : IHomeRepository {

    override suspend fun getTodayEvents() {}
}