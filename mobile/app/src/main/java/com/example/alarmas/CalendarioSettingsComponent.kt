package com.example.alarmas

import CustomDropDown
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalendarioSettingsComponent(
    modifier: Modifier = Modifier
) {
    // State to manage expanded or collapsed state
    var isExpanded by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            //.padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F2FF))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Collapsed header row with Switch and Dropdown
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Calendarios Personalizados:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Festivos de mi país",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }

                    // Switch to toggle expanded/collapsed state
                    Switch(
                        checked = switchChecked,
                        onCheckedChange = { switchChecked = it },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6A4AA1))
                    )

                    // Arrow icon to toggle expanded/collapsed state
                    IconButton(onClick = { isExpanded = !isExpanded }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Expand or Collapse"
                        )
                    }
                }

                // Expanded section with animation
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(
                            text = "Utiliza calendarios personalizados que pueden configurar días exentos o para los que no aplica tu alarma, desde desactivar algunas horas, algunos días o inclusive meses. Puedes utilizar calendarios predeterminados como “Festivos de tu país” o puedes crear tus propios calendarios en la aplicación web.",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        // Dropdown for selecting a custom calendar
                        CustomDropDown(
                            label = "Calendario personalizado",
                            options = listOf("Calendario 1", "Calendario 2", "Calendario 3"),
                            selectedValue = "Calendario 1",
                            onValueChangedEvent = { /* Handle Dropdown selection */ }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomCalendarSettings() {
    CalendarioSettingsComponent()
}
