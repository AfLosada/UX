package com.example.alarmas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BienvenidaComponent(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    var currentDataIndex by remember { mutableIntStateOf(0) }
    // We will have a list of the data we display int his control
    // Each entry will have a image ref, a title and a description
    val data = listOf(
        BienvenidaData(
            image = R.drawable.bienvenida1_lb1_b1,
            title = "Controla tu Tiempo",
            description = "Utiliza calendarios personalizados que pueden configurar días exentos o para los que no aplica tu alarma, desde desactivar algunas horas, algunos días o inclusive meses. Puedes utilizar calendarios predeterminados como “Festivos de tu país” o puedes crear tus propios calendarios en la aplicación web."
        ),
        BienvenidaData(
            image = R.drawable.bienvenida2_self_discipline,
            title = "Sin misterios y cargada de utilidad",
            description = "Puedes configurar notificaciones o recordatorios adicionales para casos en los que tu batería este baja, para que te avise que puedes perder tu alarma; Para que te avise que tu alarma sonara en algunas horas y que debes intentar dormir para disfrutar de un numero mínimo de horas de sueño."
        ),
        BienvenidaData(
            image = R.drawable.bienvenida3_attention_economy_2200x1467_1,
            title = "Para aprovechar mejor tu tiempo",
            description = "Puedes configurar un juego para desactivar tu alarma, esto para asegurarte de no desactivar la alarma antes de despertar completamente."
        )
    )

    fun decreaseIndex() {
        var newIndex = currentDataIndex - 1;
        if (newIndex < 0) {
            newIndex = data.size - 1

        }
        currentDataIndex = newIndex;
    }

    fun increaseIndex() {
        var newIndex = currentDataIndex + 1;
        if (newIndex >= data.size) {
            newIndex = 0
        }
        currentDataIndex = newIndex;
    }


    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()

    )
    {
        Row {
            Column(
                modifier = modifier

                    .padding(16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                // Top Section (Image and Title)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 36.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = data[currentDataIndex].image),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(200.dp)

                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    BasicText(
                        text = data[currentDataIndex].title,
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                // Middle Section (Description Text)
                BasicText(
                    text = data[currentDataIndex].description,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                )
                {
                    IconButton(
                        onClick = {
                            decreaseIndex()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(48.dp),
                        )
                    }

                    IconButton(
                        onClick = {
                            increaseIndex()
                        }
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Forward",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }


            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Button(
                onClick = { navController.navigate("sesion") },
                modifier = modifier
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

}

class BienvenidaData(image: Int, title: String, description: String) {

    var image by mutableStateOf(image)
    var title by mutableStateOf(title)
    var description by mutableStateOf(description)
}


@Preview
@Composable
fun PreviewBienvenidaComponent() {
    BienvenidaComponent()
}