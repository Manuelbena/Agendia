package com.example.agendia.habits.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.agendia.R
import com.example.agendia.habits.presentation.components.HabitsDateSelector
import com.example.agendia.habits.presentation.components.HomeHabit
import com.example.agendia.habits.presentation.components.HabitsQuote
import com.example.agendia.home.Presentation.HomeEvent
import com.example.agendia.home.Presentation.model.BottomNavigationItem
import com.example.agendia.navigation.NavigationRoute
import com.example.agendia.ui.theme.BackgroundPrimary
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.esmerald
import com.example.agendia.ui.theme.ivory

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HabitsScreen(
    navController: NavHostController,
    viewModel: HabitsViewModel = hiltViewModel()
) {

    // Get the state from the ViewModel
    val state = viewModel.state

    // List of navigation items
    val itemsNavigation = listOf(
        BottomNavigationItem("Inicio", Icons.Filled.Home, "home"),
        BottomNavigationItem("Calendario", Icons.Filled.DateRange, "home"),
        BottomNavigationItem("Habits", Icons.Filled.Face, "habits"),
        BottomNavigationItem("Ahorros", Icons.Filled.Star, "home")

    )

    // State to track the currently selected item
    var selectedItemIndex by remember { mutableIntStateOf(2) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "AGENDIA",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Start,
                        color = ivory,
                    )
                },
                actions = {
                    IconButton(modifier = Modifier.padding(horizontal = 16.dp),
                        onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                colors = TopAppBarColors(
                    BackgroundPrimary,
                    ivory,
                    ivory,
                    ivory,
                    ivory
                )
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = BackgroundPrimary,
                contentColor = ivory,
                tonalElevation = 10.dp
            ) {
                itemsNavigation.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(item.icon, contentDescription = item.title)
                        },
                        label = { Text(item.title) },
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(NavigationRoute.HomeScreen.route)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = esmerald
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier,
                contentColor = ivory,
                containerColor = BackgroundPrimary,
                onClick = { print("Hello") }) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundPrimary)
                .padding(innerPadding) // Add padding to the Box

        ) {

            HabitsQuote(
                quote = "Primero hacemos nuestros hábitos, y luego nuestros hábitos nos hacen a nosotros.",
                imageId = R.drawable.onboarding1,
                modifier = Modifier.padding(end = 20.dp, start = 20.dp, top = 20.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "días".uppercase(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = ivory
                )
                Spacer(modifier = Modifier.width(16.dp))

                HabitsDateSelector(
                    selectedDate = state.selectedDate,
                    mainDate = state.currentDate,
                    onDateClick = {
                        viewModel.onEvent(HomeEvent.ChangeDate(it))
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .weight(1f) // Ocupa todo el espacio restante
                    .clip(RoundedCornerShape(topStart = 25.dp))
            ) {
                item {
                    Text(
                        text = "Habitos",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        fontSize = 14.sp,
                        color = TextColor
                    )
                }

                items(state.habits) {
                    HomeHabit(
                        habit = it,
                        selectedDate = state.selectedDate.toLocalDate(),
                        onCheckedChange = { viewModel.onEvent(HomeEvent.CompleteHabit(it)) },
                        onHabitClick = { }
                    )
                }
            }

        }


    }

}

