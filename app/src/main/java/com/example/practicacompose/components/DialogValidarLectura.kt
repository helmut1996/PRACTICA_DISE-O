package com.example.practicacompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.practicacompose.R

@Composable
fun DialogValidLect(onDismissRequest: () -> Unit, onConfirmationRequest: () -> Unit) {

    var textLectAct by rememberSaveable { mutableStateOf("") }
    var textMedidorAct by rememberSaveable { mutableStateOf("") }

    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    value = textLectAct,
                    onValueChange = { textLectAct = it },
                    label = { Text("Lectura Actual") }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    value = textMedidorAct,
                    onValueChange = { textMedidorAct = it },
                    label = { Text("Numero Medidor Actual") }
                )

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onDismissRequest() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            ),

                        ) {
                        Text(text = "CONTINUAR")
                    }


            }
        }
    }
}