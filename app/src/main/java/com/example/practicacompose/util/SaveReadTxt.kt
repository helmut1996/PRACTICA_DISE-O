package com.example.practicacompose.util

import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class SaveReadTxt {


    fun crearCarpetaYArchivoEnRaiz(
        nombreCarpeta: String,
        nombreArchivo: String,
        contenido: String
    ): Boolean {
        return try {
            val directorioRaiz = Environment.getExternalStorageDirectory() // Obtiene la raíz del almacenamiento externo

            // Crea la carpeta en la raíz del almacenamiento externo si no existe
            val carpeta = File(directorioRaiz, nombreCarpeta)
            if (!carpeta.exists()) {
                carpeta.mkdirs() // Crea la carpeta y los directorios intermedios necesarios
            }

            // Crea el archivo dentro de la carpeta
            val archivo = File(carpeta, nombreArchivo)

            // Verifica si el archivo ya existe
            if (archivo.exists()) {
                // El archivo ya existe, no es necesario crearlo nuevamente
                return true
            }

            // Escribe el contenido en el archivo
            FileOutputStream(archivo).use {
                it.write(contenido.toByteArray())
            }

            true // Indica que la operación fue exitosa
        } catch (e: Exception) {
            e.printStackTrace()
            false // Indica que la operación falló
        }
    }


    fun leerArchivoEnDirectorioExterno(nombreCarpeta: String, nombreArchivo: String): String? {
        return try {
            val directorioRaiz = Environment.getExternalStorageDirectory() // Obtiene la raíz del almacenamiento externo
            val carpeta = File(directorioRaiz, nombreCarpeta)
            val archivo = File(carpeta, nombreArchivo)

            val inputStream = FileInputStream(archivo)
            val inputStreamReader = InputStreamReader(inputStream)
            val stringBuilder = StringBuilder()
            val buffer = CharArray(1024)
            var caracteresLeidos: Int

            while (inputStreamReader.read(buffer).also { caracteresLeidos = it } != -1) {
                stringBuilder.appendRange(buffer, 0, caracteresLeidos)
            }

            inputStreamReader.close()
            inputStream.close()

            stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}