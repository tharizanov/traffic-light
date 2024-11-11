package com.example.trafficlight.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.trafficlight.ui.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SetupNavGraph()
            }
        }
    }

}