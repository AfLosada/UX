package com.example.alarmas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alarmas.dashboard.Dashboard
import com.example.alarmas.idioma.Idioma

import com.example.alarmas.ui.theme.AlarmasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), // Adjust padding as necessary
                        horizontalAlignment = Alignment.CenterHorizontally // Ensure child components are centered
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth() // Take up full width
                                .weight(1f, fill = false)
                                .padding(innerPadding)
                            , // Ensure it doesn't stretch too much

                            contentAlignment = Alignment.Center // Center the content in the box
                        ) {
                            AlarmasApp()
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun AlarmasApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "idioma") {
        composable("idioma") {
            IdiomaComponent(navController)
        }
        composable("bienvenida") {
            BienvenidaComponent(navController)
        }
        composable("sesion") {
            SesionComponent(navController)
        }

        composable("login") {
            LoginComponent(navController)
        }

        composable("dashboard") {
            DashboardComponent(navController)
        }

        composable("settings-crear") {
            SettingsComponent("Crear", navController)
        }

        composable("settings-editar") {
            SettingsComponent("Editar", navController)
        }


    }
}


@Preview
@Composable
fun Preview() {
    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 4.dp)

                , // Adjust padding as necessary
                horizontalAlignment = Alignment.CenterHorizontally // Ensure child components are centered
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Take up full width
                        .weight(1f, fill = false)
                        .padding(innerPadding)
                    , // Ensure it doesn't stretch too much

                    contentAlignment = Alignment.Center // Center the content in the box
                ) {
                    IdiomaComponent()
                }
            }

        }
    }
}


