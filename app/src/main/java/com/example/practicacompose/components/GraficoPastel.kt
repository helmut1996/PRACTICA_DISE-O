package com.example.practicacompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb

import androidx.compose.ui.unit.dp

import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random


@Composable
fun ChartPie(porcentajes: Array<Float>) {
    val anguloInicial = -90f
    var anguloActual = anguloInicial
    var anguloFinal = 0f
    val total = porcentajes.sum()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier
                .padding(4.dp)
        ) {
            porcentajes.forEachIndexed { index, element ->
                Canvas(modifier = Modifier.size(250.dp)) {
                    val centerX = size.width / 2
                    val centerY = size.height / 2
                    //cuantos grados va aumentar

                    anguloFinal = (element / total) * 360
                    val midAngle = anguloActual + anguloFinal / 2
                    drawArc(
                        color = generarColorAleatorio(),
                        startAngle = anguloActual,
                        sweepAngle = anguloFinal,
                        useCenter = true,
                        style = Fill
                    )

                    anguloActual += anguloFinal

                    // Calcula las coordenadas para el texto
                    val textX = centerX + (size.width / 3) * cos(
                        Math.toRadians(midAngle.toDouble()).toFloat()
                    )
                    val textY = centerY + (size.height / 3) * sin(
                        Math.toRadians(midAngle.toDouble()).toFloat()
                    )
                    // Dibuja el texto con el porcentaje
                    val porcentaje = (element / total * 100).toInt()
                    val text = "$porcentaje%"
                    val textPaint = Paint().asFrameworkPaint()
                    textPaint.color = Color.Black.toArgb()
                    textPaint.textSize = 55f
                    textPaint.isFakeBoldText = true
                    drawContext.canvas.nativeCanvas.drawText(text, textX, textY, textPaint)
                }
            }


        }





        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Lectura Leidas")
        Text(text = "Lectura Faltantes")
        Text(text = "Facturas Impresas")
        Text(text = "Lectura Anomalias")
        Text(text = "Lectura pendientes")
    }





}

fun generarColorAleatorio(): Color {
    val random = Random.Default
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue)
}

