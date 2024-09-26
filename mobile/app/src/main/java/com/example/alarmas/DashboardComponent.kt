package com.example.alarmas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardComponent(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Alarm Card List
        Column {
            AlarmCard(navController, alarmLabel = "A", time = "7:00 A.M.")
            Spacer(modifier = Modifier.height(16.dp))
            AlarmCard(navController, alarmLabel = "B", time = "7:00 A.M.")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Button(
                onClick = { navController.navigate("settings-crear") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4AA1))
                ,
                content = {
                    Text(
                        text = "Crear",
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

@Composable
fun AlarmCard(
    navController: NavController,
    alarmLabel: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F2FF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Avatar with letter
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFD0BCFF), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = alarmLabel, color = Color.White, fontSize = 20.sp)
            }

            // Time Text
            Text(text = time, fontSize = 18.sp)

            // Toggle Switch
            var isChecked by remember { mutableStateOf(false) }
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6A4AA1))
            )

            // Settings Icon
            IconButton(onClick = { navController.navigate("settings-editar") }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings", tint = Color(0xFF6A4AA1))
            }
        }

        // Days of the Week
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 56.dp, top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val daysOfWeek = listOf("L", "M", "M", "J", "V", "S", "D")
            daysOfWeek.forEach { day ->
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color(0xFFEADDFF), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = day, color = Color(0xFF6A4AA1))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DashboardComponent()
}

