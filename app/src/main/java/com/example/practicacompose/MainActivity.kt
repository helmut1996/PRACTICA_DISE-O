package com.example.practicacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.practicacompose.components.ChartPie
import com.example.practicacompose.components.DialogWarning
import com.example.practicacompose.ui.theme.PracticaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PracticaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //content()
                    
                    ChartPie(arrayOf(0.5f, 0.25f, 0.25f,0.30f,0.25f))
                }
            }
        }
    }
}

@Composable
fun content() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog = true }) {
            Text(text = "Dialog warning")
        }

        if (showDialog) {
            DialogWarning(
                onDismissRequest = { showDialog = false },
                onConfirmationRequest = { showDialog = false }
            )
        }
    }

}


