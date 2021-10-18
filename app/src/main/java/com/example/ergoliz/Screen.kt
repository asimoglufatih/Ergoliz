package com.example.ergoliz

sealed class Screen(val route: String){
    object UpperArmScreen: Screen("upper_arm_screen")
    object LowerArmScreen: Screen("lower_arm_screen")
    object WristScreen: Screen("wrist_screen")
    object ShowTableAScreen: Screen("table_A_screen")
}
