package com.example.agendia.home.Presentation

import com.example.agendia.habits.domain.models.Habit
import java.time.ZonedDateTime


sealed interface HomeEvent {
    data class ChangeDate(val date: ZonedDateTime) : HomeEvent
    data class CompleteHabit(val habit: Habit) : HomeEvent
}