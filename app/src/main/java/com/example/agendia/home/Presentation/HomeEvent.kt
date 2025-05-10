package com.example.agendia.home.Presentation

import java.time.ZonedDateTime


sealed interface HomeEvent {
    data class ChangeDate(val date: ZonedDateTime) : HomeEvent
}