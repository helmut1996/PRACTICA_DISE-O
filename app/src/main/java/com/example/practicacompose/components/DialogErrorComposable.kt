package com.example.practicacompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.practicacompose.R


@Composable
fun DialogErrorComposable( onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.size(20.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_dialog),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp),
                    tint = Color.Blue
                )
                Text(
                    text = "Inicio secion Exitoso!!", fontSize = 25.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))
                ProgregresCircular()

            }
        }
    }
}


@Composable
fun ProgregresCircular() {
    CircularProgressIndicator(
        modifier = Modifier.size(50.dp),
        color= Color.Blue,
        strokeWidth = 5.dp
    )
}

@Composable
fun LinearProgress(){
    LinearProgressIndicator()
}