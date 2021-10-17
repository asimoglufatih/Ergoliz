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
fun LowerArmScreen(navController: NavController){
    
    Column() {

        var lowerArmScore = 0
        var outLinedTextFieldScore = 0

        Text(
            text = "Etap 2: Alt Kol Pozisyonlarını Bulun.",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(20.dp))

        //OutLinedText ve DropdownMenu için ayrı Column
        Column(modifier = Modifier.padding(20.dp)) {

            var expanded by remember { mutableStateOf(false) }
            val suggestions = listOf(
                "Ön kol 60° ile 100° arasında",
                "Ön kol 0° ile 60° arasında",
                "Ön kol 100°+"
            )
            var selectedText by remember { mutableStateOf("") }
            var textfieldSize by remember { mutableStateOf(Size.Zero) }

            when(selectedText){
                suggestions[0] -> outLinedTextFieldScore = 1
                suggestions[1] -> outLinedTextFieldScore = 2
                suggestions[2] -> outLinedTextFieldScore = 2
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

        Spacer(Modifier.height(20.dp))

        //Switch için ayrı column
        Column(modifier = Modifier.padding(20.dp)) {
            
            Text(text = "Lütfen aşağıdaki seçeneği değerleniriniz.")
            
            Spacer(modifier = Modifier.height(30.dp))
            
            val lowerArmSwitch = remember { mutableStateOf(false)}
            
            var lowerArmSwitchScore = if (lowerArmSwitch.value) 1 else 0

            lowerArmScore = outLinedTextFieldScore + lowerArmSwitchScore
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                
                Switch(
                    checked = lowerArmSwitch.value ,
                    onCheckedChange = {lowerArmSwitch.value = it} )

                Spacer(modifier = Modifier.width(40.dp))
                
                Text(text = "Kollardan biri bel hizasında veya ayrık mı?")
            }

        }
        Spacer(Modifier.height(30.dp))
        
        //lowerArmScore ve buton için ayrı Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Alt Kol Skoru: $lowerArmScore")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.navigate(Screen.WristScreen.route) }) {
                Text(text = "Onayla")
                
            }

        }



    }
    
}