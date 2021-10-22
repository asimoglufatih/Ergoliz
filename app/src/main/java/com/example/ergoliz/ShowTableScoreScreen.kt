package com.example.ergoliz

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ShowTableAScreen(navController: NavController){
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Üst Kol Pozisyonu Skoru: ${TableA.upperArmScore}")
        Text(text = "Alt Kol Pozisyonu Skoru: ${TableA.lowerArmScore}")
        Text(text = "Bilek Skoru: ${TableA.wristPositionScore}")
        Text(text = "Bilek Bükülme Skoru: ${TableA.wristTwistScore}")
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Text(text = "Tablo A Skoru: ${TableA.tableAScore}")
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Button(onClick = { navController.navigate(Screen.FindRowInTableCScreen.route)}) {
            
            Text(text = "Onayla")
            
        }
        
    }

}

@Composable
fun ShowTableBScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Boyun Pozisyonu Skoru: ${TableB.neckScore}")
        Text(text = "Gövde Pozisyonu Skoru: ${TableB.trunkScore}")
        Text(text = "Bacak Pozisyonu Skoru: ${TableB.legScore}")

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Tablo B Skoru: ${TableB.tableBScore}")

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screen.FindColumnInTableCScreen.route) }) {

            Text(text = "Onayla")

        }

    }

}


@Composable
fun ShowTableCScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Tablo C satır skoru: ${TableC.rowOfTableC}")
        Text(text = "Tablo C sütun skoru: ${TableC.columnOfTableC}")


        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "RULA Skoru: ${TableC.tableCScore}")

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screen.FindRowInTableCScreen.route)}) {

            Text(text = "Onayla")

        }

    }

}