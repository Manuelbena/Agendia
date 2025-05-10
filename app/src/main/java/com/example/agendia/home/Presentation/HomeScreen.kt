@file:Suppress("UNREACHABLE_CODE")

package com.example.agendia.home.Presentation


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
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
import androidx.navigation.NavHostController
import com.example.agendia.R
import com.example.agendia.home.Presentation.model.BottomNavigationItem
import com.example.agendia.home.Presentation.model.Task
import com.example.agendia.navigation.NavigationRoute
import com.example.agendia.ui.theme.BackgroundPrimary
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.esmerald
import com.example.agendia.ui.theme.ivory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(
    navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()
) {
    // List of navigation items

    // Get today's date
    val today = LocalDate.now()

    // Format the date as "dd 'de' MMMM 'de' yyyy" (e.g., "08 de enero de 2023")
    val formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy")
    val formattedDate = today.format(formatter)

    // State to track the currently selected item
    var selectedItemIndex by remember { mutableIntStateOf(0) }


    Scaffold(
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
                        fontSize = 16.sp
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
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier,
                contentColor = ivory,
                containerColor = BackgroundPrimary,
                onClick = { print("Hello") }) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundPrimary)
                .padding(innerPadding) // Add padding to the Box
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Row de saludo y fecha
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(start = 20.dp),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            text = "Hola, Manuel",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Start,
                            color = ivory,
                            fontSize = 16.sp
                        )

                        Text(
                            text = formattedDate,
                            modifier = Modifier.padding(horizontal = 12.dp),
                            color = ivory,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Start,
                        )
                    }
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.ic_lluvia),
                            contentDescription = "Imagen de perfil",
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = "17ªC",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp,
                            color = ivory
                        )
                    }

                }

                // Card rellena
                val tasks = listOf(
                    Task("09:00", "Reunión con el equipo de diseño", "Oficina principal", true),
                    Task("10:00", "Presentación del proyecto", "Sala de conferencias", false),
                    Task("11:00", "Revisión de código de ayer", "Oficina", false),
                    Task("12:00", "Reunión con el equipo de diseño", "Oficina principal", false),
                    Task("12:45", "Presentación del proyecto", "Sala de conferencias", false),
                    Task("12:55", "Revisión de código", "Oficina", false),
                )


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // Añade el scroll vertical
                        .background(Color.White),
                ) {
                    // Lista de información de hoy
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Tareas programados para hoy",
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

                        ItemToday(tasks) //eventos de hoy

                        Text(
                            text = "Ver todas los tareas para hoy",
                            textDecoration = TextDecoration.Underline,
                            lineHeight = 25.sp,
                            overflow = TextOverflow.Ellipsis,
                            color = TextColor,
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )

                    }
                    ItemEvent(task = tasks) // Fin de todos los eventos de hoy
                }
            }
        }
    }
}


@Composable
fun ItemToday(task: List<Task>) {

    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {

        task.take(3).forEach { activity ->
            ActivityRow(activity)
        }
    }
}

@Composable
fun ActivityRow(activity: Task) {
    Row(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center

    ) {

        Text(
            text = activity.date, style = MaterialTheme.typography.bodyMedium, color = Color.Gray
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            if (activity.isActive) {
                Canvas(modifier = Modifier.size(24.dp)) {
                    drawCircle(color = TextColor, radius = size.minDimension / 3)
                }
            } else {
                Canvas(modifier = Modifier.size(24.dp)) {
                    drawCircle(color = esmerald, radius = size.minDimension / 3)
                }
            }

            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(60.dp)
                    .background(TextColor)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = activity.summary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                color = TextColor,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp
            )
            Text(
                text = activity.location,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp
            )
        }


    }
}


@Composable
fun ItemEvent(task: List<Task>) {
    Column(
    ) {
        Text(
            text = "Próximas Tareas",
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

        LazyRow(
            Modifier.fillMaxSize(),
        ) {
            items(task) { task ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(160.dp)
                        .padding(top = 2.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = ivory,
                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = task.summary,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 2,
                            color = TextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp
                        )
                    }
                    HorizontalDivider(
                        color = BackgroundPrimary, thickness = 10.dp
                    )
                }
            }
        }
        Text(
            text = "Ver próximas tareas",
            textDecoration = TextDecoration.Underline,
            lineHeight = 25.sp,
            overflow = TextOverflow.Ellipsis,
            color = TextColor,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

