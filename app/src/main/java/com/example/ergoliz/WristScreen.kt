package com.example.ergoliz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController

@Composable
fun WristScreen(navController: NavController){

    Column {

        var wristScreenScore = 0
        var outLinedTextFieldScore = 0

        Text(
            text = "Etap 3: Bilek Pozisyonunu Bulun.",
            modifier = Modifier.padding(30.dp),
            style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(20.dp)) {

            var expanded by remember { mutableStateOf(false)}
            val suggestions = listOf(
                "0°",
                "iki yönden 15°",
                "yukarı yöne 15° +",
                "aşağı yöne 15° +"
            )

            var selectedText by remember { mutableStateOf("")}
            var textfieldSize by remember { mutableStateOf(Size.Zero)}

            when(selectedText){
                suggestions[0] -> outLinedTextFieldScore = 1
                suggestions[1] -> outLinedTextFieldScore = 2
                suggestions[2] -> outLinedTextFieldScore = 3
                suggestions[3] -> outLinedTextFieldScore = 3
                else -> outLinedTextFieldScore = 0
            }

            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            OutlinedTextField(
                value = selectedText,
                onValueChange = {selectedText = it},
                enabled = false,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text(text = "Lütfen birini seçiniz.")},
                trailingIcon = {
                    Icon(icon, contentDescription = "contentDescription",
                        Modifier.clickable{expanded = !expanded})
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){textfieldSize.width.toDp()})
            ) {
                suggestions.forEach{ label ->
                    DropdownMenuItem(onClick = {
                        selectedText = label
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }

            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        //Switch için ayrı Column
        Column(modifier = Modifier.padding(20.dp)){
            Text(text = "Lütfen aşağıdaki seçeneği değerlendiriniz.")

            Spacer(modifier = Modifier.height(30.dp))

            val wristScreenSwitch = remember { mutableStateOf(false)}

            var wristScreenSwitchScore = if (wristScreenSwitch.value) 1 else 0
            
            wristScreenScore = wristScreenSwitchScore + outLinedTextFieldScore
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                
                Switch(
                    checked = wristScreenSwitch.value , 
                    onCheckedChange = {wristScreenSwitch.value = it})

                Spacer(modifier = Modifier.width(40.dp))

                Text(text = "Bilek bükülmüş mü?")
            }
            
        }
        
        Spacer(modifier = Modifier.height(30.dp))
        
        //wristScreenScore ve buton için ayrı Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Bilek Skoru $wristScreenScore")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ }) {
                
                Text(text = "Onayla")
                
            }
            
        }
    }
}