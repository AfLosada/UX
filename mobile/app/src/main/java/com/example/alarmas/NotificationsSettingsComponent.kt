package com.example.alarmas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
fun NotificationsSettingsComponent(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F2FF))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Notificaciones:                         ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Batería baja, Email",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                    Switch(
                        checked = switchChecked,
                        onCheckedChange = {
                            switchChecked = it
                            isExpanded = it
                        },
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

                // Expanded section
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Text(
                            text = "Puedes configurar notificaciones o recordatorios adicionales para casos en los que tu batería este baja, para que te avise que puedes perder tu alarma; Para que te avise que tu alarma sonara en algunas horas y que debes intentar dormir para disfrutar de un número mínimo de horas de sueño.",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        Divider()

                        NotificationTimePicker(
                            title = "Notificación de Batería",
                            description = "Cuanto tiempo antes quieres que suene?"
                        )

                        Divider()

                        NotificationTimePicker(
                            title = "Notificación Tiempo de Sueño",
                            description = "Cuanto tiempo antes quieres que suene?"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationTimePicker(title: String, description: String) {
    var switchChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {

            Row {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Switch(
                        checked = switchChecked,
                        onCheckedChange = { switchChecked = it },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6A4AA1))
                    )
                }

                Column {

                    Row {
                        TimePickerComponent(label = "Horas", time = "07")
                        Text(":", fontSize = 32.sp, modifier = Modifier.align(Alignment.CenterVertically))
                        TimePickerComponent(label = "Minutos", time = "00")
                    }
                }
            }
        }
    }
}

@Composable
fun TimePickerComponent(label: String, time: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .padding(4.dp)
                .background(Color(0xFFD0BCFF), RoundedCornerShape(8.dp))
                    ,
            contentAlignment = Alignment.Center
        ) {
            Text(text = time, fontSize = 32.sp, color = Color(0xFF6A4AA1))
        }
        Text(label, fontSize = 14.sp, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotificationSettings() {
    NotificationsSettingsComponent()
}
