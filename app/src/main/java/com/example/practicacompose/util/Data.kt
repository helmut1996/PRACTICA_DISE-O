package com.example.practicacompose.util

import android.os.Build

data class Data (
    val maker: String? = Build.MANUFACTURER,
    val model: String? = Build.MODEL,
    val  data1: String? = Build.BOARD,
    val data2: String? = Build.ID,
    val data3: String? = Build.HARDWARE,
    val data4: String? = Build.BOOTLOADER,
    val data5: String? = Build.USER,
    val data6: String? = Build.TYPE,
)