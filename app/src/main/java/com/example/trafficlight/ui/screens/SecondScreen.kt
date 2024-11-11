package com.example.trafficlight.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

object Light {
    const val GREEN = "GREEN"
    const val ORANGE = "ORANGE"
    const val RED = "RED"
    const val RED_ORANGE = "RED_ORANGE"
}

val ORANGE = Color(0xFFFFBB00)

@Composable
fun SecondScreen(carModel: String) {
    var activeLight by remember { mutableStateOf(Light.GREEN) }

    LaunchedEffect(Unit) {
        while (true) {
            activeLight = Light.GREEN
            delay(4000)
            activeLight = Light.ORANGE
            delay(1000)
            activeLight = Light.RED
            delay(4000)
            activeLight = Light.RED_ORANGE
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Car Model: $carModel", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(40.dp))

        LightCircle(
            color = Color.Red,
            isActive = activeLight == Light.RED || activeLight == Light.RED_ORANGE
        )

        Spacer(modifier = Modifier.height(16.dp))

        LightCircle(
            color = ORANGE,
            isActive = activeLight == Light.ORANGE || activeLight == Light.RED_ORANGE
        )

        Spacer(modifier = Modifier.height(16.dp))

        LightCircle(
            color = Color.Green,
            isActive = activeLight == Light.GREEN
        )
    }
}

@Composable
fun LightCircle(color: Color, isActive: Boolean) {
    val animatedColor by animateColorAsState(
        targetValue = if (isActive) color else color.copy(alpha = 0.2f),
        animationSpec = tween(durationMillis = 300),
        label = ""
    )

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(animatedColor, shape = CircleShape)
    )
}
