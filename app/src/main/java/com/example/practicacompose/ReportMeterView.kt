package com.example.practicacompose

import android.annotation.SuppressLint
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicacompose.components.SpinnerAnomalia
import com.example.practicacompose.components.SpinnerObs
import com.example.practicacompose.components.SpinnerUso

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportMeterView() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "ReportMeter ") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentReportMeterView()
    }
}


@Composable
fun ContentReportMeterView() {
    var textDireccion by rememberSaveable { mutableStateOf("") }
    var textComentario by rememberSaveable { mutableStateOf("") }
    var textMedidor by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(PaddingValues())
            .padding(top = 80.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "REPORTAR MEDIDOR DE ENERGIA",
            fontFamily = FontFamily(Font(R.font.neuehassdisplay_light))
        )
        Image(
            painter = painterResource(id = R.drawable.barra_aes),
            contentDescription = "",
            modifier = Modifier.size(height = 10.dp, width = 350.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            FilledIconButton(
                onClick = { /* doSomething() */ },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp),
                    tint = Color.Blue
                )
            }
            FilledIconButton(
                onClick = { /* doSomething() */ },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_image),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp),
                    tint = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "ANL:",
                fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(paddingValues = PaddingValues(vertical = 40.dp))
            )
            SpinnerAnomalia()
        }

        Row {
            Text(
                text = "OBS:",
                fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(paddingValues = PaddingValues(vertical = 40.dp))
            )
            SpinnerObs()
        }


        Text(
            text = "USO DE LA ENERGIA",
            fontFamily = FontFamily(Font(R.font.neuehassdisplay_light))
        )
        Row {
            Text(
                text = "USO:",
                fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(paddingValues = PaddingValues(vertical = 40.dp))
            )
            SpinnerUso()
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textDireccion,
            onValueChange = { textDireccion = it },
            label = { Text("Direccion de referencia") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textComentario,
            onValueChange = { textComentario = it },
            label = { Text("Comentario") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column {

            Text(text = "Medidor no registrado")
            Row {
                OutlinedTextField(
                    modifier = Modifier.width(100.dp),
                    value = textMedidor,
                    onValueChange = { textMedidor = it },
                    label = { Text("Medidor") }
                )

                Row(modifier = Modifier.padding(20.dp)) {
                    Text(text = "PREMID: ")
                }


            }

            Row(
                modifier = Modifier.padding(
                    paddingValues = PaddingValues(
                        horizontal = 120.dp
                    )
                )
            ) {
                Text(
                    text = "MEDIDOR: ", fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.padding(
                    paddingValues = PaddingValues(
                        horizontal = 150.dp
                    )
                )
            ) {
                Text(
                    text = "IR COD: ", fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    PaddingValues(
                        horizontal = 10.dp
                    )
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.White
            )
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(
                "REPORTAR MEDIDOR",
                fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSpiner2() {
    ReportMeterView()
}