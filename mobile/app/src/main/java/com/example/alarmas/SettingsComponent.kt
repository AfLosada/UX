package com.example.alarmas

import CustomDropDown
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun SettingsComponent(
    contexto: String = "Crear",
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier.background(Color.White)
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    )
    {


        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            // Time Picker Section
            TimePickerSection(contexto)
            Spacer(modifier = Modifier.height(24.dp))

            // Repetition Section
            Text("Repetición", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            DaysOfWeekSelector()
            Spacer(modifier = Modifier.height(16.dp))

            // Sound Dropdown Section
            CustomDropDown(
                selectedValue = "Sonido 1",
                options = listOf("Sonido 1", "Sonido 2", "Sonido 3"),
                label = "Sonido",
                onValueChangedEvent = { /* Handle selected value change */ }
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Settings Options
            CalendarioSettingsComponent(modifier = Modifier.fillMaxWidth())
            GameSettingsComponent(modifier = Modifier.fillMaxWidth())
            NotificationsSettingsComponent(modifier = Modifier.fillMaxWidth())
            SleepSettingsComponent(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(24.dp))

            // Save Button
            Button(
                onClick = { navController.navigate("Dashboard") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = CircleShape,
                //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4AA1))
            ) {
                Text(text = "Guardar", color = Color.White)
            }
        }
    }
}

@Composable
fun TimePickerSection(
    contexto: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F2FF))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$contexto Alarma",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Hour Selector
                TimeBox("08", "Hora", isHighlighted = true)
                Spacer(modifier = Modifier.width(8.dp))
                Text(":", fontSize = 36.sp)
                Spacer(modifier = Modifier.width(8.dp))
                // Minute Selector
                TimeBox("00", "Minuto", isHighlighted = false)
                Spacer(modifier = Modifier.width(16.dp))
                // AM/PM Toggle
                AMPMToggle()
            }
        }
    }
}

@Composable
fun TimeBox(time: String, label: String, isHighlighted: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (isHighlighted) Color(0xFFEADDFF) else Color(0xFFDADADA)),
            contentAlignment = Alignment.Center
        ) {
            Text(time, fontSize = 32.sp, color = if (isHighlighted) Color(0xFF6A4AA1) else Color.Black)
        }
        Text(label, fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
fun AMPMToggle() {
    var isAM by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFDADADA)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(if (isAM) Color(0xFFFFCDD2) else Color(0xFFDADADA)),
            contentAlignment = Alignment.Center
        ) {
            Text("AM", fontSize = 16.sp, color = if (isAM) Color.Black else Color.Gray)
        }
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(if (!isAM) Color(0xFFE0E0E0) else Color(0xFFDADADA)),
            contentAlignment = Alignment.Center
        ) {
            Text("PM", fontSize = 16.sp, color = if (!isAM) Color.Black else Color.Gray)
        }
    }
}

@Composable
fun DaysOfWeekSelector() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val days = listOf("L", "M", "M", "J", "V", "S", "D")
        days.forEach { day ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD0BCFF)),
                contentAlignment = Alignment.Center
            ) {
                Text(day, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsComponent() {
    SettingsComponent()
}
