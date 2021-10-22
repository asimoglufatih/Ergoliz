package com.example.ergoliz

sealed class Screen(val route: String){
    object UpperArmScreen: Screen("upper_arm_screen")
    object LowerArmScreen: Screen("lower_arm_screen")
    object WristScreen: Screen("wrist_screen")
    object ShowTableAScreen: Screen("table_a_screen")
    object FindRowInTableCScreen: Screen("table_c_row_screen")
    object NeckPositionScreen: Screen("neck_position_screen")
    object TrunkPositionScreen: Screen("trunk_position_screen")
    object ShowTableBScreen: Screen("table_b_screen")
    object FindColumnInTableCScreen: Screen("table_c_column_screen")
    object ShowTableCScreen: Screen("table_c_screen")

}
