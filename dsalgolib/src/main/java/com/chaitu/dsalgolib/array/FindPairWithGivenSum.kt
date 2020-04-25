package com.chaitu.dsalgolib.array

object FindPairWithGivenSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val sum = 16
        val list = arrayOf(4, 7, 10, 6, 1, 8, 9)

        findPairWithSum(list, sum)
    }

    private fun findPairWithSum(list: Array<Int>, sum: Int) {
        val map = HashMap<Int, Int>()

        for (i in list.indices) {
            val currentValue = list[i]
            val invertedValue = sum - currentValue
            if (map.containsKey(currentValue)) {
                println("Pair : $invertedValue & $currentValue")
                map.remove(invertedValue)
            } else {
                map[invertedValue] = i
            }
        }
    }
}