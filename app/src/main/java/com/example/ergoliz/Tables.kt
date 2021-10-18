package com.example.ergoliz

class Tables {


    companion object elementsOftableA{

        var upperArmScore: Int = 0
        var lowerArmScore: Int = 0
        var wristPositionScore: Int= 0
        var wristTwistScore: Int = 0
        var tableAScore = 0

        private val tableA = arrayOf(
            arrayOf(
                arrayOf(1,2,2,2,2,3,3,3),
                arrayOf(2,2,2,2,3,3,3,3),
                arrayOf(2,3,3,3,3,3,4,4)),
            arrayOf(
                arrayOf(2,3,3,3,3,4,4,4),
                arrayOf(3,3,3,3,3,4,4,4),
                arrayOf(3,4,4,4,4,4,5,5)),
            arrayOf(
                arrayOf(3,3,4,4,4,4,5,5),
                arrayOf(3,4,4,4,4,4,5,5),
                arrayOf(4,4,4,4,4,5,5,5)),
            arrayOf(
                arrayOf(4,4,4,4,4,5,5,5),
                arrayOf(4,4,4,4,4,5,5,5),
                arrayOf(4,4,4,5,5,5,6,6)),
            arrayOf(
                arrayOf(5,5,5,5,5,6,6,7),
                arrayOf(5,6,6,6,6,6,7,7),
                arrayOf(6,6,6,7,7,7,7,8)),
            arrayOf(
                arrayOf(7,7,7,7,7,8,8,9),
                arrayOf(8,8,8,8,8,9,9,9),
                arrayOf(9,9,9,9,9,9,9,9)),
        )

        fun calculateTableAScore(): Int {

            val lastArray= (2 * (wristPositionScore - 1)) + (wristTwistScore - 1)
            tableAScore = tableA[upperArmScore - 1][lowerArmScore - 1][lastArray]

            return tableAScore
        }

    }



}