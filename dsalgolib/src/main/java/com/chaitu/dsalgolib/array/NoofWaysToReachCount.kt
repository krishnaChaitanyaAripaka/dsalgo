package com.chaitu.dsalgolib.array

object NoofWaysToReachCount {
    @JvmStatic
    fun main(args: Array<String>) {
        println(countWay(13))

    }

    private fun countWay(n: Int): Int {
        //table to store count for each value of i
        var table = IntArray(n + 1)
        var i = 0

        for (i in 0..n) {
            // Initialize all table values as 0
            table[i] = 0
        }

        //set for 1 for input as 0
        table[0] = 1

        //try to solve using 3
        for (i in 3..n)
            table[i] += table[i - 3]

        //try to solve using 5
        for (i in 5..n)
            table[i] += table[i - 5]

        //try to solve using 10
        for (i in 10..n)
            table[i] += table[i - 10]

        return table[n]
    }
}