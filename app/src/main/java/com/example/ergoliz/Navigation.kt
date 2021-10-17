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
            route = Screen.UpperArmScreen.route){
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

        }
    }
}