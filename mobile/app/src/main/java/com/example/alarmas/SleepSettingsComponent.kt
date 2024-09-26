package com.example.alarmas
import CustomDropDown
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
fun SleepSettingsComponent(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            ,
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
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Calidad del sueño:                   ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Calm",
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
                        colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6A4AA1)),
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    // Arrow icon to toggle expanded/collapsed state
                    IconButton(onClick = { isExpanded = !isExpanded }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Expand or Collapse"
                        )
                    }
                }

                AnimatedVisibility(
                    visible = isExpanded,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Column {
                        Text(
                            text = "Puedes sincronizar la información recopilada por la aplicación con tu aplicación de monitoreo de sueño con las que tenemos compatibilidad.",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        CustomDropDown(
                            label = "",
                            options = listOf("Calm", "Zepp", "Mi Salud"),
                            selectedValue = "Calm",
                            onValueChangedEvent = { /* Handle Drop-down logic */ }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSleepToWakeUpSettings() {
    SleepSettingsComponent()
}
