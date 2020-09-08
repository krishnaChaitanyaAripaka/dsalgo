package com.chaitu.dsalgolib.array

object FindPairWithGivenSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val sum = 16
        val list = intArrayOf(4, 7, 10, 6, 1, 8, 9)

        println(findPairWithSum(list, sum))
    }

    private fun findPairWithSum(list: IntArray, sum: Int): List<Pair<Int, Int>> {
        val map = HashMap<Int, Int>()
        val pairs = ArrayList<Pair<Int, Int>>()
        for (i in list.indices) {
            val currentValue = list[i]
            val invertedValue = sum - currentValue
            if (map.containsKey(currentValue)) {
                pairs.add(currentValue to invertedValue)
                println("Pair : $invertedValue & $currentValue")
                map.remove(invertedValue)
            } else {
                map[invertedValue] = i
            }
        }

        return pairs
    }
}