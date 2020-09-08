package com.chaitu.dsalgolib.array

object MinNoOfCoinsToMakeGivenValue {

    @JvmStatic
    fun main(args: Array<String>) {

        val coins = intArrayOf(9, 6, 5, 1)
        val value = 11

        println(minCoins(coins, coins.size, value))
    }

    private fun minCoins(coins: IntArray, size: Int, value: Int): Int {
        val table = IntArray(value + 1)
        table[0] = 0
        for (i in 1 until table.size) {
            table[i] = Int.MAX_VALUE
        }

        for (i in 1..value) {
            for (j in 0 until size) {
                if (coins[j] <= i) {
                    var subResult = table[i - coins[j]]
                    if (subResult != Int.MAX_VALUE && subResult + 1 < table[i]) {
                        table[i] = subResult + 1
                    }
                }
            }
        }
        return table[value]
    }

}