package com.example.alarmas

import CustomDropDown
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun IdiomaComponent(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(16.dp)
            .background(Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Language Image Section
        LanguageImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )

        // Custom Dropdown for language selection
        CustomDropDown (
            selectedValue = "Español",  // Set initial selected value
            options = listOf("Español", "English", "Français"),
            label = "Idioma",
            onValueChangedEvent = { /* Handle selected value change */ }
        )

        // Spacer to add some vertical space
        Spacer(modifier = Modifier.height(24.dp))

        // Continue Button
        Button(
            onClick = { navController.navigate("bienvenida") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                    //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4AA1))
                    ,
            content = {
                Text(
                    text = "Continuar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }
}

@Composable
fun LanguageImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.idioma_imagen_idioma),  // Replace with your image resource
        contentDescription = "Language Map",
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 100.dp)
        //round the edges
        .clip(RoundedCornerShape(8.dp))
        ,
        contentScale = ContentScale.FillWidth
    )
}

@Preview
@Composable
fun PreviewIdiomaComponent() {
    MaterialTheme {
        IdiomaComponent()
    }
}
