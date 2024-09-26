import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alarmas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropDown(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier.padding(horizontal = 24.dp)
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(selectedValue) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "Drop down arrow")
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options
                .forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
    /*var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(selectedValue) }

    Box()
    {
        // Label Text
        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 18.dp)
                .fillMaxWidth()
        )

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            // Dropdown Box
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                // TextField with Dropdown
                TextField(
                    value = selected,
                    onValueChange = {},
                    readOnly = true,
                    label = null,  // Hide default label
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded }
                        .background(
                            Color.White,
                            RoundedCornerShape(8.dp)
                        )  // White background with rounded corners
                        //.padding(24.dp)
                        .menuAnchor(),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )

                // Dropdown Menu Items
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                onValueChangedEvent(option)
                                expanded = false
                                selected = option
                            },
                            text = {
                                Text(
                                    text = option,
                                    fontSize = 16.sp,  // Font size similar to the design
                                    color = Color.Black,
                                    modifier = Modifier.padding(12.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }*/
}

@Preview
@Composable
fun PreviewCustomDropDown() {
    CustomDropDown(
        selectedValue = "Español",
        options = listOf("Español", "English", "Français"),
        label = "Idioma",
        onValueChangedEvent = {}
    )
}
