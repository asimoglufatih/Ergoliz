package com.example.ergoliz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ShowTableAScreen(navController: NavController){
    
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Üst Kol Pozisyonu Skoru: ${Tables.upperArmScore}")
        Text(text = "Alt Kol Pozisyonu Skoru: ${Tables.lowerArmScore}")
        Text(text = "Bilek Skoru: ${Tables.wristPositionScore}")
        Text(text = "Bilek Bükülme Skoru: ${Tables.wristTwistScore}")
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Text(text = "Tablo A Skoru: ${Tables.tableAScore}")
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Button(onClick = { /*TODO*/ }) {
            
            Text(text = "Onayla")
            
        }
        
    }

}