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
import com.example.practicacompose.components.DialogValidLect
import com.example.practicacompose.components.DialogWarning
import com.example.practicacompose.components.PieChartView
import com.example.practicacompose.ui.theme.PracticaComposeTheme
import com.example.practicacompose.util.Data
import com.example.practicacompose.util.SaveReadTxt
import com.example.practicacompose.views.EjemploCrearCarpetaYArchivo
import com.example.practicacompose.views.IndustrialRading
import com.example.practicacompose.views.Sample
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

class MainActivity : ComponentActivity() {
    private lateinit var saveReadTxt: SaveReadTxt

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            saveReadTxt = SaveReadTxt()
            PracticaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //content()

                    // ChartPie(arrayOf(0.5f, 0.25f, 0.25f,0.30f,0.25f))

                    //   PieChart(arrayOf(5, 25, 25,30,25))
                    // IndustrialRading()


                    val multiplePermissionsState = rememberMultiplePermissionsState(
                        listOf(
                            android.Manifest.permission.RECORD_AUDIO,
                            android.Manifest.permission.CAMERA,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        )
                    )

                    //Sample(multiplePermissionsState)
                    //EjemploCrearCarpetaYArchivo()
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog = true }) {
            Text(text = "Dialog warning")
        }

        if (showDialog) {
            DialogValidLect(
                onDismissRequest = { showDialog = false },
                onConfirmationRequest = { showDialog = false }
            )
        }
    }

}


