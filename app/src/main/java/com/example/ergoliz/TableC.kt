package com.example.ergoliz

class TableC {

    companion object elementsOfTableC{

        var rowOfTableC = 0
        var columnOfTableC = 0
        //RULA Skoru
        var tableCScore = 0

        private val tableC = arrayOf(
            arrayOf(1,2,3,3,4,5,5),
            arrayOf(2,2,3,4,4,5,5),
            arrayOf(3,3,3,4,4,5,6),
            arrayOf(3,3,3,4,5,6,6),
            arrayOf(4,4,4,5,6,7,7),
            arrayOf(4,4,5,6,6,7,7),
            arrayOf(5,5,6,6,7,7,7),
            arrayOf(5,5,6,7,7,7,7)
        )

        fun CalculateTableCScore(){
            if (rowOfTableC >= 8) rowOfTableC = 8
            if (columnOfTableC >= 7) columnOfTableC = 7

            tableCScore = tableC[rowOfTableC - 1][columnOfTableC - 1]
        }

    }

}