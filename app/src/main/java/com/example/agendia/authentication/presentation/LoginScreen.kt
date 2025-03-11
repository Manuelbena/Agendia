package com.example.agendia.authentication.presentation


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.agendia.authentication.presentation.components.LoginWithGoogleButton
import com.example.agendia.navigation.NavigationHost
import com.example.agendia.navigation.NavigationRoute
import com.example.agendia.ui.theme.ColorBlue
import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.ivory

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = ColorBlue)
    ) {

        // Card arriba

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(color = ivory),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 100.dp, bottom = 24.dp),
                text = "AGENDIA",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,

                color = TextColor,
                fontSize = 44.sp
            )
            HorizontalDivider(thickness = 2.dp, color = TextColor)
            Text(
                modifier = Modifier.padding(bottom = 24.dp, top = 24.dp),
                text = "2025",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                color = TextColor,
                fontSize = 34.sp
            )


        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            text = "\"Lo que se escribe, se recuerda." +
                    "\nLo que se observa, se mejora.\n " +
                    "Lo que se revisa, evoluciona\"",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = ivory,
            fontSize = 18.sp
        )
        LoginWithGoogleButton(
            onClick = {
                navController.navigate(NavigationRoute.HomeScreen.route)

            },
            text = "Iniciar sesión",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
        )
    }
}

