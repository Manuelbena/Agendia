package com.example.agendia.home.Presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agendia.R
import com.example.agendia.home.Presentation.model.Task
import com.example.agendia.ui.theme.ColorBlue
import com.example.agendia.ui.theme.ivory

@Preview(showBackground = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBlue)
    ) {

        // Row de saludo y fecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),

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
                        .size(80.dp)
                )
                Text(
                    text = "17ªC",
                    color = ivory,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                )
            }
        }

        // Card rellena
        FilledCardExample(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp)),
        )




    }


}



@Composable
fun FilledCardExample(
    modifier: Modifier
) {
    val tasks = listOf(
        Task("09:00", "Reunión con el equipo de diseño", "Oficina principal"),
        Task("10:00", "Presentación del proyecto", "Sala de conferencias"),
        Task("11:00", "Revisión de código", "Oficina"),
        Task("12:00", "Reunión con el equipo de diseño", "Oficina principal"),
        Task("12:45", "Presentación del proyecto", "Sala de conferencias"),
        Task("12:55", "Revisión de código", "Oficina"),
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = ivory,
        ),
        modifier = modifier
            .padding(top = 10.dp).fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 300.dp, width = 120.dp),

        ) { // Lista de información de hoy
            Text(
                text = "Eventos programados hoy",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Start,
            )

            LazyColumn {
                items(tasks) { task ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = ivory,
                        ),

                    ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier
                                    .padding(12.dp)
                            ){
                                Text(
                                    text = "${task.date}",
                                    fontSize = 12.sp)

                            }
                            Column ( modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()){
                                Text(
                                    text = "Resumen: ${task.summary}",
                                    fontSize = 12.sp)
                                Text(
                                    text = "Lugar: ${task.location}",
                                    fontSize = 12.sp)
                            }
                        }


                    }
                }
            }
        }
        Column(modifier = Modifier
            .padding(top = 8.dp)
        ) {
            Text(
                text = "Proximas Tareas",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                textAlign = TextAlign.Start,
            )

            LazyRow  (
                Modifier
                    .fillMaxSize(),
            ) {
                items(tasks) { task ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(height = 130.dp, width = 120.dp)
                            .padding(top = 2.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = ivory,
                        ),

                        ) {
                        Column (
                            modifier = Modifier
                                .padding(12.dp)
                        ){
                            Text(
                                text = "${task.summary}",
                                fontSize = 12.sp)

                        }

                    }
                }
            }
        }
    }

}

@Composable
fun FloatingActionButtonExample(modifier: Modifier) {
    FloatingActionButton(onClick = { print("Hello") }) {
        Icon(Icons.Filled.Favorite, "Floating action button.")
    }
}
