package com.example.ergoliz

class TableB {

    companion object elementsOfTableB{

        var neckScore = 0
        var trunkScore = 0
        var legScore = 0
        var tableBScore = 0

        private val tableB = arrayOf(
            arrayOf(
                arrayOf(1,2,3,5,7,8),
                arrayOf(3,3,3,5,7,8)
            ),
            arrayOf(
                arrayOf(2,2,3,5,7,8),
                arrayOf(3,3,4,6,7,8)
            ),
            arrayOf(
                arrayOf(3,4,4,6,7,8),
                arrayOf(4,5,5,7,8,8)
            ),
            arrayOf(
                arrayOf(5,5,5,7,8,8),
                arrayOf(5,5,6,7,8,9)
            ),
            arrayOf(
                arrayOf(6,6,6,7,8,9),
                arrayOf(6,7,7,7,8,9)
            ),
            arrayOf(
                arrayOf(7,7,7,8,8,9),
                arrayOf(7,7,7,8,8,9)
            )
        )

        fun calculateTableBScore(){
            tableBScore = tableB[trunkScore - 1][legScore - 1][neckScore - 1]
        }
    }

}