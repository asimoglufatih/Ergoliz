package com.example.ergoliz

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.UpperArmScreen.route){
        composable(
            route = Screen.UpperArmScreen.route
        ){
            UpperArmScreen(navController = navController)
        }
        composable(
            route = Screen.LowerArmScreen.route
        ){
            LowerArmScreen(navController = navController)
        }
        composable(
            route = Screen.WristScreen.route
        ){
            WristScreen(navController = navController)
        }
        composable(
            route = Screen.ShowTableAScreen.route
        ){
            ShowTableAScreen(navController = navController)
        }
        composable(
            route = Screen.FindRowInTableCScreen.route
        ){
            FindRowInTableCScreen(navController = navController)
        }
        composable(
            route = Screen.NeckPositionScreen.route
        ){
            NeckPositionScreen(navController = navController)
        }
        composable(
            route = Screen.TrunkPositionScreen.route
        ){
            TrunkPositionScreen(navController = navController)
        }
        composable(
            route = Screen.ShowTableBScreen.route
        ){
            ShowTableBScreen(navController = navController)
        }
        composable(
            route = Screen.FindColumnInTableCScreen.route
        ){
            FindColumnInTableCScreen(navController = navController)
        }
        composable(
            route = Screen.ShowTableCScreen.route
        ){
            ShowTableCScreen(navController = navController)
        }

    }
}