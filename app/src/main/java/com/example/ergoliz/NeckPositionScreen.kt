package com.example.ergoliz

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NeckPositionScreen(navController: NavController){

    Column {

        var neckPositionScore = 0
        var outLinedTextFieldScore = 0

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Boyun pozisyonunu bulun.",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(20.dp)) {

            val suggestions = listOf(
                "0 - 10 derece arasında",
                "10 - 20 derece arasında",
                "20 dereceden fazla",
                "0 dereceden daha küçük",
            )

            when(MakeTextFieldWithDropDownMenu(
                suggestion = suggestions,
                "Boyun açısı")){
                suggestions[0] -> outLinedTextFieldScore = 1
                suggestions[1] -> outLinedTextFieldScore = 2
                suggestions[2] -> outLinedTextFieldScore = 3
                suggestions[3] -> outLinedTextFieldScore = 4
                else -> outLinedTextFieldScore = 0
            }

        }
        
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(20.dp)) {
            
            Text(text = "Lütfen aşağıdakileri ayrı ayrı değerlendirerek işaretleyiniz.")
            Spacer(modifier = Modifier.height(20.dp))

            val Switch1 = remember { mutableStateOf(false) }
            val Switch2 = remember { mutableStateOf(false) }

            val Switch1Score = if(Switch1.value){ 1} else 0
            val Switch2Score = if(Switch2.value){ 1} else 0

            neckPositionScore = outLinedTextFieldScore + Switch1Score + Switch2Score

            Row(verticalAlignment = Alignment.CenterVertically) {

                Switch(checked = Switch1.value, onCheckedChange ={ Switch1.value = it} )

                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "Boyun bükülüyorsa işaretleyin"
                )

            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                Switch(checked = Switch2.value, onCheckedChange ={ Switch2.value = it} )

                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "Boyun yana eğilmişse işaretleyin"
                )

            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =Modifier.fillMaxWidth()) 
        {
            
            Text(text = "Boyun skoru: $neckPositionScore")

            Spacer(modifier = Modifier.height(20.dp))
            
            Button(onClick = {
                if (neckPositionScore > 0){
                    TableB.neckScore = neckPositionScore
                    navController.navigate(Screen.TrunkPositionScreen.route)
                }
            }) {
                
                Text(text = "Onayla")
                
            }
            
            
        }

    }

}