package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingWithButtonAndInput(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingWithButtonAndInput(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("nueva rama") }
    var input by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Hello $name!")

        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Ingrese nombre") },
            modifier = Modifier.padding(top = 8.dp)
        )

        Button(
            onClick = { if (input.isNotBlank()) name = input },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Establecer nombre rama nueva")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        GreetingWithButtonAndInput()
    }
}
