package com.example.trafficlight.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trafficlight.ui.navigation.Route

@Composable
fun FirstScreen(navController: NavController) {
    var carModel by remember { mutableStateOf(TextFieldValue("")) }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter your car model:", style = MaterialTheme.typography.bodyLarge)

        TextField(
            value = carModel,
            onValueChange = {
                carModel = it
                isError = carModel.text.length < 3
            },
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(
                text = "Car model must be at least 3 characters.",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (!isError) {
                    navController.navigate(Route.SecondScreen.replace("{carModel}", carModel.text))
                }
            },
            enabled = !isError
        ) {
            Text("Start Driving")
        }
    }
}
