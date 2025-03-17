package com.example.agendia.habits.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.agendia.home.Presentation.HomeEvent


@HiltViewModel
class HabitsViewModel@Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(HabitsState())
        private set

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.ChangeDate -> {
                state = state.copy(
                    selectedDate = event.date,
                )
                    // getHabits()
            }
            is HomeEvent.CompleteHabit -> {
                //TODO: Complete habit
            }
        }
    }
/*
    private fun getHabits() {
        currentDayJob?.cancel()
        currentDayJob = viewModelScope.launch {
            homeUseCases.getHabitsForDateUseCase(state.selectedDate).collectLatest {
                state = state.copy(
                    habits = it
                )
            }
        }
    }*/
}