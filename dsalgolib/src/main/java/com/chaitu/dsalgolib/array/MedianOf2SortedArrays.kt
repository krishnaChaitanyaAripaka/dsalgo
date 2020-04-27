package com.chaitu.dsalgolib.array

import kotlin.math.max
import kotlin.math.min

/**
 * DS : Binary Search
 * Time Complexity : O(log(min(arr1, arr2)))
 * Space Complexity : O(1)
 */
object MedianOf2SortedArrays {
    @JvmStatic
    fun main(args: Array<String>) {
        /**
         * Merged array should look like 1, 2, 3, 4, (5, 6), 34, 37, 42, 49 -> (5 + 6)/2 -> 5.5 is the median
         */
//        val arr1 = intArrayOf(34, 37, 42, 49)
//        val arr2 = intArrayOf(1, 2, 3, 4, 5, 6)

        /**
         * Merged array should look like 1, 2, 6, 8, 10, 19, 42, 47, 50, 55, 60 -> 19 -> 19 is the median
         */
        val arr1 = intArrayOf(2, 19, 42, 47, 55)
        val arr2 = intArrayOf(1, 6, 8, 10, 50, 60)

        println("Median of 2 sorted arrays is : ${getMedium(arr1, arr2)}")
    }

    private fun getMedium(arr1: IntArray, arr2: IntArray): Double {
        if (arr1.size > arr2.size) {
            return getMedium(arr2, arr1)
        }

        var low = 0
        var high = arr1.size

        var l1 = arr1.size
        var l2 = arr2.size

        //Doing binary search for arr1
        while (low <= high) {
            var partitionX = (low + high) / 2
            var partitionY = (l1 + l2 + 1) / 2 - partitionX

            var maxLeftX = if (partitionX == 0) Int.MIN_VALUE else arr1[partitionX - 1]
            var minRightX = if (partitionX == l1) Int.MAX_VALUE else arr1[partitionX]

            var maxLeftY = if (partitionY == 0) Int.MIN_VALUE else arr2[partitionY - 1]
            var minRightY = if (partitionY == l2) Int.MAX_VALUE else arr2[partitionY]

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                return if ((l1 + l2) % 2 == 0) {
                    (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)).toDouble() / 2
                } else {
                    max(maxLeftX.toDouble(), maxLeftY.toDouble())
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1
            } else {
                low = partitionX + 1
            }
        }
        return (-1).toDouble()
    }
}