package com.example.alarmas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SesionComponent(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier.background(Color.White)
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Inicia sesión, o continua anónimo",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall,
            modifier = modifier.padding(top = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.login1_image_1_login1),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(200.dp)
                .padding(bottom = 32.dp)
        )

        Box (
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)


        )
        {
            Column {
                // "Anónimo" Button
                Button(
                    onClick = { navController.navigate("dashboard") },
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = CircleShape
                ) {
                    Text(
                        text = "Anónimo",
                        color = Color.White
                    )
                }

                // "Inicia sesión" Button
                OutlinedButton(
                    onClick = { navController.navigate("login") },
                    modifier = modifier.fillMaxWidth()
                        .padding(top = 24.dp),
                    shape = CircleShape,
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
                    //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4AA1))
                ) {
                    Text(
                        text = "Inicia sesión"
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun PreviewSesionComponent() {
    SesionComponent()
}