package com.example.agendia.habits.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agendia.core.presentation.HabitCheckbox
import com.example.agendia.habits.domain.models.Habit
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.ivory
import java.time.LocalDate

@Preview
@Composable
fun HomeHabit(
    habit: Habit,
    selectedDate: LocalDate,
    onCheckedChange: () -> Unit,
    onHabitClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
            .background(Color.White)
            .clickable {
                onHabitClick()
            }
            .padding(top = 10.dp, start = 8.dp, end = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = ivory,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = habit.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                color = TextColor,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,

            )
            HabitCheckbox(isChecked = habit.completedDates.contains(selectedDate)) {
                onCheckedChange()
            }
        }

    }
}