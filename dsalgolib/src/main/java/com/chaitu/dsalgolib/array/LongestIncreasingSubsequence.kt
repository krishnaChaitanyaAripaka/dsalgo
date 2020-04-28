package com.chaitu.dsalgolib.array

import kotlin.math.max

object LongestIncreasingSubsequence {
    @JvmStatic
    fun main(args: Array<String>) {
//        val arr = intArrayOf(3, 4, -1, 0, 6, 2, 3)
        val arr = intArrayOf(8, 10, 6, 5, 11, 9, 12, 15, 20)
        println("Longest increasing subsequence : ${longestIncreasingSubsequence(arr)}")
    }

    private fun longestIncreasingSubsequence(arr: IntArray): Int {
        val temp = IntArray(arr.size)
        for (i in temp.indices) {
            temp[i] = 1
        }

        for (i in 1 until arr.size) {
            for (j in 0..i) {
                if (arr[j] < arr[i]) {
                    temp[i] = max(temp[i], temp[j] + 1)
                }
            }
        }

        var result = 0
        for (i in temp.indices) {
            if (temp[i] > result) {
                result = temp[i]
            }
        }
        return result
    }
}