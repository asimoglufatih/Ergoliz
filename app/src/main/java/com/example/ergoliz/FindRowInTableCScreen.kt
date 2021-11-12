package com.example.ergoliz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController

@Composable
fun FindRowInTableCScreen(navController: NavController){

    Column() {

        var outLinedTextFieldScore1 = 0
        var outLinedTextFieldScore2 = 0

        Text(
            text = "Tablo C'nin satırını bulun.",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h5)
        
        Spacer(modifier = Modifier.height(20.dp))

        //Kas kullanımı skorunu seçmek için oluşturulan DropDownMenü'nün düzgün çalışması için
        Column(modifier = Modifier.padding(20.dp)) {

            val suggestions1 = listOf(
                "Statik duruş veya statiğe yakın",
                "Tekrarlı duruş",
            )

            when(MakeTextFieldWithDropDownMenu(suggestion = suggestions1,"Kas Kullanımı")){
                suggestions1[0] -> outLinedTextFieldScore1 = 0
                suggestions1[1] -> outLinedTextFieldScore1 = 1
                else -> outLinedTextFieldScore1 = 0
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        //Uygulanan yük skorunu seçmek için oluşturulan DropDownMenü'nün düzgün çalışması için
        Column(modifier = Modifier.padding(20.dp)) {

            val suggestions2 = listOf(
                "<2kg",
                "2-10kg aralıklarla uygulanmış",
                "2-10kg statik uygulanmış",
                ">10kg tekrarlı veya ani uygulanmış",
            )

            when(MakeTextFieldWithDropDownMenu(
                suggestion = suggestions2,
                "Maruz kalınan yük/Uygulanan kuvvet")){
                suggestions2[0] -> outLinedTextFieldScore2 = 0
                suggestions2[1] -> outLinedTextFieldScore2 = 1
                suggestions2[2] -> outLinedTextFieldScore2 = 2
                suggestions2[3] -> outLinedTextFieldScore2 = 3
                else -> outLinedTextFieldScore2 = 0
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(text = "Kas kullanımı skoru: $outLinedTextFieldScore1")
            Text(text = "Uygulanan yük skoru: $outLinedTextFieldScore2")


            Button(onClick = {
                TableC.rowOfTableC = outLinedTextFieldScore1 + outLinedTextFieldScore2 + TableA.tableAScore
                navController.navigate(Screen.NeckPositionScreen.route)}) {

                Text(text = "Onayla")

            }
        }



    }

}