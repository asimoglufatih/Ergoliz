package com.example.ergoliz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize

@Composable
fun WristTwist(): Int{

    var outLinedTextFieldScore = 0

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf(
        "Bilek, bükülme alanının ortasında",
        "Sonunda ya da yakınında",
    )

    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    when(selectedText){
        suggestions[0] -> outLinedTextFieldScore = 1
        suggestions[1] -> outLinedTextFieldScore = 2
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
        label = { Text(text = "Lütfen birini seçiniz.") },
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

    return outLinedTextFieldScore
}

@Composable
fun showTableA(){

}
