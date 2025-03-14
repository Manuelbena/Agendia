package com.example.agendia.habits


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agendia.R
import com.example.agendia.habits.components.HomeDateSelector
import com.example.agendia.habits.components.HomeQuote
import com.example.agendia.home.Presentation.ItemEvent
import com.example.agendia.home.Presentation.ItemToday
import com.example.agendia.home.Presentation.model.BottomNavigationItem
import com.example.agendia.home.Presentation.model.Task
import com.example.agendia.ui.theme.BackgroundPrimary
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.esmerald
import com.example.agendia.ui.theme.ivory
import java.time.ZonedDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HabitsScreen(

    viewModel: HabitsViewModel = hiltViewModel()
) {


    // List of navigation items
    val items = listOf(
        BottomNavigationItem("Inicio", Icons.Filled.Home, "home"),
        BottomNavigationItem("Calendario", Icons.Filled.DateRange,"home"),
        BottomNavigationItem("Habits", Icons.Filled.Face, "habits"),
        BottomNavigationItem("Ahorros", Icons.Filled.Star, "home")

    )

    // State to track the currently selected item
    var selectedItemIndex by remember { mutableIntStateOf(2) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "AGENDIA",
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
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(item.icon, contentDescription = item.title)
                    },
                    label = { Text(item.title) },
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = esmerald
                    )
                )
            }
        }
    }) {innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundPrimary)
                .padding(innerPadding) // Add padding to the Box
        ) {

        //Contenido de la pantalla de Habitos
            HomeQuote(
                quote = "Primero creamos nuestros hábitos, luego nuestros hábitos nos crean a nosotros.",
                imageId = R.drawable.onboarding1,
                modifier = Modifier
                    .padding(20.dp)
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
                HomeDateSelector(
                    selectedDate = ZonedDateTime.now(),
                    mainDate = ZonedDateTime.now(),
                    onDateClick = {}
                )
            }

            FilledCardHabits(   modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ocupa todo el espacio restante
                .clip(RoundedCornerShape(topStart = 25.dp))) // Redondea solo la esquina superior izquierda)

        }

    }
}

@Composable
fun FilledCardHabits(
    modifier: Modifier
) {
    val tasks = listOf(
        Task("09:00", "Reunión con el equipo de diseño", "Oficina principal", true),
        Task("10:00", "Presentación del proyecto", "Sala de conferencias", false),
        Task("11:00", "Revisión de código de ayer", "Oficina", false),
        Task("12:00", "Reunión con el equipo de diseño", "Oficina principal", false),
        Task("12:45", "Presentación del proyecto", "Sala de conferencias", false),
        Task("12:55", "Revisión de código", "Oficina", false),
    )


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Añade el scroll vertical
            .background(Color.White),
    ) {
        // Lista de información de hoy
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Habitos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                fontSize = 14.sp,
                color = TextColor
            )
        }
    }


}