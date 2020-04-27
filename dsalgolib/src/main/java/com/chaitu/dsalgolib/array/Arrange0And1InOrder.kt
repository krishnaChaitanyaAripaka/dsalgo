package com.chaitu.dsalgolib.array

import com.chaitu.dsalgolib.utils.print

object Arrange0And1InOrder {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0)

        arrange(array)

        array.print()
    }

    private fun arrange(array: IntArray) {
        var left = 0
        var right = array.size - 1

        while (left < right) {
            while (array[left] == 0 && left < right) {
                left++
            }

            while (array[right] == 1 && left < right) {
                right--
            }

            if (left < right) {
                array[left] = 0
                array[right] = 1
                left++
                right--
            }
        }
    }
}