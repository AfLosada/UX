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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginComponent(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier.background(Color.White)
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Inicia sesión",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = 32.dp)
        )

        Box()
        {
            Column {
                // Email Field
                var email by remember { mutableStateOf("") }
                OutlinedTextFieldWithClearButton(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Correo Electrónico",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onClearClick = { email = "" }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password Field
                var password by remember { mutableStateOf("") }
                OutlinedTextFieldWithClearButton(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Contraseña",
                    onClearClick = { password = "" },
                    isPassword = true
                )
            }
        }


        Box (
            modifier = modifier.padding(bottom = 32.dp)
        ) {
            Column {
                // "Iniciar Sesión" Button
                Button(
                    onClick = { navController.navigate("dashboard") },
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = CircleShape,
                    //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4AA1))
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        color = Color.White
                    )
                }


                // "Continuar Anónimo" Button
                OutlinedButton(
                    onClick = { navController.navigate("dashboard") },
                    modifier = modifier.fillMaxWidth()
                        .padding(top = 24.dp),
                    shape = CircleShape,
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6A4AA1))
                ) {
                    Text(
                        text = "Continuar Anónimo"
                    )
                }
            }
        }


    }
}

@Composable
fun OutlinedTextFieldWithClearButton(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onClearClick: () -> Unit,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                "$placeholder:",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 18.dp)

        ) },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = onClearClick) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear")
                }
            }
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = keyboardOptions,
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    )
}

@Preview
@Composable
fun PreviewLoginComponent() {
    LoginComponent()
}