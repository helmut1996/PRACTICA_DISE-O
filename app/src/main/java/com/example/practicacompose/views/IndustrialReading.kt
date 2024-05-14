package com.example.practicacompose.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicacompose.R
import com.example.practicacompose.components.SpinnerAnomalia
import com.example.practicacompose.components.SpinnerObs

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IndustrialRading() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "IndustrialReading",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF214ADE)
                ),
            )

        }
    ) {
        ContentIndustrialRading(it)
    }
}


@Composable
fun ContentIndustrialRading(pd: PaddingValues) {
    var textValle by rememberSaveable { mutableStateOf("") }
    var textResto by rememberSaveable { mutableStateOf("") }
    var textPunta by rememberSaveable { mutableStateOf("") }
    var textDemanda by rememberSaveable { mutableStateOf("") }
    var textFactorPotencia by rememberSaveable { mutableStateOf("") }
    var textComentario by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(pd)
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor =  Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        tint = Color(0xFF214ADE))
                }

                Text(text = "5221743")
                Text(text = "N°1")
                Text(text = "RD.5")

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "",
                        tint = Color(0xFF214ADE))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "",
                    tint = Color(0xFF214ADE))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_image),
                    contentDescription = "",
                    tint = Color(0xFF214ADE))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "",
                    tint = Color(0xFF214ADE))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_change),
                    contentDescription = "",
                    tint = Color(0xFF214ADE))
            }
        }

        Image(
            painter = painterResource(id = R.drawable.barra_aes),
            contentDescription = "",
            modifier = Modifier.size(height = 11.dp, width = 380.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Column {
                Text(text = "Cliente",
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_light)),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "HELMUT JOSUE COLINDRES BRENES",
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_light)),
                            fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Column(modifier= Modifier
                .padding(start = 30.dp)
                .fillMaxWidth()) {
                Text(text = "Punto medida",
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_light)),
                    fontWeight = FontWeight.Bold
                    )
                Text(text = "PARED",fontSize = 15.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Direccion",
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = FontFamily(Font(R.font.neuehassdisplay_light)),
            fontWeight = FontWeight.Bold
        )
        Text(text = "ESTA ES UNA DIRECCION DE PRUEBA PARA VER COMO SE COMPORTA",
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 15.sp,
            color = Color.Gray)

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textValle,
            onValueChange = { textValle = it },
            label = { Text("Valle") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textResto,
            onValueChange = { textResto = it },
            label = { Text("Resto") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textPunta,
            onValueChange = { textPunta = it },
            label = { Text("Punta") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textDemanda,
            onValueChange = { textDemanda = it },
            label = { Text("Demanda") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textFactorPotencia,
            onValueChange = { textFactorPotencia = it },
            label = { Text("Factor de Potencia") }
        )
        SpinnerAnomalia()
        SpinnerObs()
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = textComentario,
            onValueChange = { textComentario = it },
            label = { Text("Comentario") }
        )
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                modifier = Modifier
                    .padding(
                        PaddingValues(
                            horizontal = 10.dp
                        )
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF214ADE),
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
                    "REPORTAR",
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Button(
                onClick = { },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                modifier = Modifier
                    .padding(
                        PaddingValues(
                            horizontal = 10.dp
                        )
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8BC34A),
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_save),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    "GUARDAR",
                    fontFamily = FontFamily(Font(R.font.neuehassdisplay_bold)),
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }
    }
}