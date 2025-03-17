package com.example.agendia.habits.presentation

import com.example.agendia.habits.domain.models.Habit
import java.time.ZonedDateTime


sealed interface HabitsEvent {
    data class ChangeDate(val date: ZonedDateTime) : HabitsEvent
    data class CompleteHabit(val habit: Habit) : HabitsEvent
}