package com.chaitu.dsalgolib.array

import java.util.*
import kotlin.collections.ArrayList

/**
 * Find the nearest smaller numbers on left side in an array
 */
object NearestSmallerNumber {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1, 6, 4, 10, 2, 5)

        println(nearestSmallerNumbersArray(array))
    }

    private fun nearestSmallerNumbersArray(array: IntArray): ArrayList<String> {
        val result = ArrayList<String>(array.size)

        val stack = Stack<Int>()
        for (i in array.indices) {

            while (stack.isNotEmpty() && stack.peek() > array[i]) {
                stack.pop()
            }

            if (stack.isEmpty()) {
                result.add("_")
            } else {
                result.add(stack.peek().toString())
            }

            stack.push(array[i])
        }

        return result
    }
}