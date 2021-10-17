package com.example.ergoliz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun UpperArmScreen(navController: NavController) {

    Column {

        var upperArmScore = 0
        var outLinedTextFieldScore = 0

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Etap 1: Üst Kol Pozisyonlarını Bulun.",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(20.dp))

        //OutLinedText ve DropdownMenu için ayrı Column
        Column(modifier = Modifier.padding(20.dp)) {

            var expanded by remember { mutableStateOf(false) }
            val suggestions = listOf(
                "Kollar vücuda bitişik 20°",
                "Kollar arkada 20°+",
                "20° - 45° arası",
                "45° - 90° arası", "90°+"
            )
            var selectedText by remember { mutableStateOf("") }
            var textfieldSize by remember { mutableStateOf(Size.Zero) }

            when(selectedText){
                suggestions[0] -> outLinedTextFieldScore = 1
                suggestions[1] -> outLinedTextFieldScore = 2
                suggestions[2] -> outLinedTextFieldScore = 2
                suggestions[3] -> outLinedTextFieldScore = 3
                suggestions[4] -> outLinedTextFieldScore = 4
                else -> outLinedTextFieldScore = 0
            }

            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            OutlinedTextField(
                value = selectedText ,
                onValueChange = {selectedText = it},
                enabled = false,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text(text = "Lütfen birini seçiniz")},
                trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(with(LocalDensity.current){textfieldSize.width.toDp()})
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedText = label
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
            //Switchler için ayrı column
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Lütfen aşağıdaki seçenekleri ayrı ayrı değerlendirerek işaretleyiniz.")
                Spacer(modifier = Modifier.height(30.dp))
                val upperArmSwitch1 = remember { mutableStateOf(false) }
                val upperArmSwitch2 = remember { mutableStateOf(false) }
                val upperArmSwitch3 = remember { mutableStateOf(false) }

                val upperArmSwitch1Score = if(upperArmSwitch1.value){ 1} else 0
                val upperArmSwitch2Score = if(upperArmSwitch2.value){ 1} else 0
                val upperArmSwitch3Score = if(upperArmSwitch3.value){ -1} else 0

                upperArmScore = outLinedTextFieldScore + upperArmSwitch1Score +
                        upperArmSwitch2Score + upperArmSwitch3Score

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Switch(
                        checked = upperArmSwitch1.value,
                        onCheckedChange = {upperArmSwitch1.value = it}
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "Omuzlar kaldırıldı mı?"
                    )
                    Spacer(modifier = Modifier.width(40.dp))

                }
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Switch(
                        checked = upperArmSwitch2.value,
                        onCheckedChange = {upperArmSwitch2.value = it}
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "Kollar vücuttan uzakta mı?"
                    )

                }
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Switch(
                        checked = upperArmSwitch3.value,
                        onCheckedChange = {upperArmSwitch3.value = it}
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "Kol destekleniyor veya vücut eğiliyor mu?"
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

        //Üst kol skoru ve alt kol geçiş butonu için ayrı column
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Üst Kol Skoru: $upperArmScore",
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { navController.navigate(Screen.LowerArmScreen.route) },

                ) {
                    Text(text = "Onayla")

                }
            }
            
        }
    }


@Composable
@Preview
fun UpperArmScreenPreview(){

}