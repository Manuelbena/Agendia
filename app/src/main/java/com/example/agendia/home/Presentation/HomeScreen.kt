package com.example.agendia.home.Presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agendia.R
import com.example.agendia.home.Presentation.model.Task
import com.example.agendia.ui.theme.ColorBlue
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.esmerald
import com.example.agendia.ui.theme.ivory

@Preview(showBackground = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBlue)
    ) {

        // Row de saludo y fecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    text = "Hola, Manuel",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start,
                    color = ivory,
                    fontSize = 16.sp
                )
                Text(
                    text = "08 de enero de 2023",
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    color = ivory,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_lluvia),
                    contentDescription = "Imagen de perfil",
                    modifier = Modifier
                        .size(60.dp)
                )
                Text(
                    text = "17ªC",
                    color = ivory,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                )
            }
        }
        // Fin del saludo y fecha

        // Inicio de Card
        FilledCard(
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 150.dp)
                .clip(RoundedCornerShape(topStart = 30.dp)),
        )
        // Fin de Card


        BottomNavigationBarExample(
            modifier = Modifier
                .align(Alignment.BottomCenter)

        )

    }



}


@Composable
fun FilledCard(
    modifier: Modifier
) {
    val tasks = listOf(
        Task("09:00", "Reunión con el equipo de diseño", "Oficina principal"),
        Task("10:00", "Presentación del proyecto", "Sala de conferencias"),
        Task("11:00", "Revisión de código de ayer", "Oficina"),
        Task("12:00", "Reunión con el equipo de diseño", "Oficina principal"),
        Task("12:45", "Presentación del proyecto", "Sala de conferencias"),
        Task("12:55", "Revisión de código", "Oficina"),
    )


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Añade el scroll vertical
            .background(ivory),
    ) {
        // Lista de información de hoy
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Eventos programados hoy",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Start,
            )

            ItemToday(tasks) //eventos de hoy

            Text(
                text = "Ver todos los eventos",
                textDecoration = TextDecoration.Underline,
                lineHeight = 25.sp,
                overflow = TextOverflow.Ellipsis,
                color = ColorBlue,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )

        }



        ItemEvent(task = tasks) // Fin de todos los eventos de hoy


        FloatingActionButtonExample(
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = 25.dp)
                .padding(16.dp)
        )

    }


}


@Composable
fun FloatingActionButtonExample(modifier: Modifier) {
    FloatingActionButton(
        modifier = modifier,
        contentColor = ivory,
        containerColor = TextColor,
        onClick = { print("Hello") }) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun ItemToday(task: List<Task>) {

    task.take(3).forEach { eventToday ->
        Column {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = ivory,
                ),

                ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "09:00",
                            fontSize = 12.sp
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    )
                    {
                        Text(
                            text = "Resumen: Reunión con el equipo de diseño",
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Lugar: Oficina principal",
                            fontSize = 12.sp
                        )
                    }

                }
            }


        }
    }

}

@Composable
fun ItemEvent(task: List<Task>) {
    Column(
    ) {
        Text(
            text = "Proximas Tareas",
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            textAlign = TextAlign.Start,
        )

        LazyRow(
            Modifier
                .fillMaxSize(),
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
                        modifier = Modifier
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${task.summary}",
                            maxLines = 2,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp
                        )
                    }
                    HorizontalDivider(
                        color = ColorBlue,
                        thickness = 10.dp
                    )
                }
            }
        }
        Text(
            text = "Ver Todas las tareas",
            textDecoration = TextDecoration.Underline,
            lineHeight = 25.sp,
            overflow = TextOverflow.Ellipsis,
            color = ColorBlue,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun BottomNavigationBarExample(modifier: Modifier) {

    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists", "Settigns")
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.AddCircle, Icons.Filled.DateRange, Icons.Filled.Settings)
    val unselectedIcons =
        listOf(Icons.Filled.Home, Icons.Outlined.AddCircle, Icons.Outlined.Star, Icons.Filled.Settings)

    NavigationBar (
        modifier = modifier,
        containerColor = ColorBlue,
        contentColor = ivory,
    ){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
