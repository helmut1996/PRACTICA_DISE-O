package com.example.practicacompose.components
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.practicacompose.R
import ir.mahozad.android.PieChart


@Composable
fun PieChartView() {
    val c1 = Color.Blue
    val c2 = Color.LightGray
    val c3 = Color.Green
    val c4 = Color.Red
    val c5 = Color.Yellow
    val c6 = Color.Black

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            PieChart(context).apply {
                slices = listOf(
                    PieChart.Slice(
                        0.3f,
                        color = c1.toArgb(),
                        legend = "Lect. leidas",
                        labelColor = c6.toArgb(),
                        legendColor = c6.toArgb(),
                        labelIcon = R.drawable.ic_lect_leidas,
                        labelIconTint = c1.toArgb()
                    ),
                    PieChart.Slice(
                        0.2f,
                        color = c2.toArgb(),
                        legend = "Lect. faltantes",
                        labelColor = c6.toArgb(),
                        legendColor = c6.toArgb(),
                        labelIcon = R.drawable.ic_lect_faltantes,
                        labelIconTint = c2.toArgb()
                    ),
                    PieChart.Slice(
                        0.2f,
                        color = c3.toArgb(),
                        legend = "Facturas impresas",
                        labelColor = c6.toArgb(),
                        legendColor = c6.toArgb(),
                        labelIcon = R.drawable.ic_print,
                        labelIconTint = c3.toArgb()
                    ),
                    PieChart.Slice(
                        0.17f,
                        color = c4.toArgb(),
                        legend = "Lect. Anomalo",
                        labelColor = c6.toArgb(),
                        legendColor = c6.toArgb(),
                        labelIcon = R.drawable.ic_anomalia,
                        labelIconTint = c4.toArgb()
                    ),
                    PieChart.Slice(
                        0.13f,
                        color = c5.toArgb(),
                        legend = "Reporte de medidor",
                        labelColor = c6.toArgb(),
                        legendColor = c6.toArgb(),
                        labelIcon = R.drawable.ic_reporte_medidor,
                        labelIconTint = c5.toArgb()

                    ),
                )
                labelIconsTint = c6.toArgb()
                startAngle = -90
                isLegendEnabled = true
                labelType = PieChart.LabelType.OUTSIDE
                labelIconsPlacement = PieChart.IconPlacement.TOP
                gradientType = PieChart.GradientType.SWEEP
                holeRatio = 0f
                overlayRatio = 0.75f

            }
        },

        )
}




