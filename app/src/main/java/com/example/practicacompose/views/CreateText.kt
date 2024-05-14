package com.example.practicacompose.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practicacompose.util.Data
import com.example.practicacompose.util.SaveReadTxt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun EjemploCrearCarpetaYArchivo() {
    var resultado by remember { mutableStateOf("") }
    val Data by remember { mutableStateOf(Data()) }
     lateinit var saveReadTxt: SaveReadTxt

    LaunchedEffect(Unit) {
        val resultadoCoroutine = withContext(Dispatchers.IO) {
            saveReadTxt = SaveReadTxt()
            val carpetaCreada = saveReadTxt.crearCarpetaYArchivoEnRaiz("Key2", "Keys", "Contenido del archivo sin extencion txt - ${Data.model.toString()}")
            if (carpetaCreada) {
                saveReadTxt.leerArchivoEnDirectorioExterno("Key2", "Keys")
            } else {
                null
            }
        }
        resultado = resultadoCoroutine ?: "Error al crear la carpeta y el archivo"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = resultado)
    }
}