package com.chaitu.dsalgolib.matrix

object FindElementInSortedMatrix {
    /**          col 0   col1    col2    col3    col4
    row 0 ->    1,      3,      5,      7       9
    row 1 ->    10,     11,     16,     17      19
    row 2 ->    20,     21,     23,     27      29
    row 3 ->    30,     31,     33,     37      39
    row 4 ->    40,     41,     43,     47      49
    row 5 ->    50,     51,     53,     57      59
    row 6 ->    60,     61,     63,     67      69
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val list =
            arrayOf(
                intArrayOf(1, 3, 5, 7, 9),
                intArrayOf(10, 11, 16, 17, 19),
                intArrayOf(20, 21, 23, 27, 29),
                intArrayOf(30, 31, 33, 37, 39),
                intArrayOf(40, 41, 43, 47, 49),
                intArrayOf(50, 51, 53, 57, 59),
                intArrayOf(60, 61, 63, 67, 69)
            )
        val element = 67

        val pair = findElementInSortedMatrix(list, element)
        if (pair.first >= list.size || pair.second == -1) {
            println("Element $element not found")
        } else {
            println("Index of the element $element in matrix : $pair")
        }

    }

    private fun findElementInSortedMatrix(list: Array<IntArray>, element: Int): Pair<Int, Int> {
        val rowSize = list.size
        val colSize = list[0].size
        val currentColumn = colSize - 1
        var low = 0
        var high = rowSize - 1

        while (low <= high) {
            var mid = (low + high) / 2
            when {
                element > list[mid][currentColumn] -> {
                    low = mid + 1
                }
                element < list[mid][currentColumn] -> {
                    high = mid - 1
                }
                element == list[mid][currentColumn] -> {
                    return Pair(mid, currentColumn)
                }
            }
        }

        val finalRow = low
        if (finalRow >= list.size) {
            return Pair(finalRow, -1)
        }
        val finalCol = binarySearch1DArray(list[finalRow], element, 0, colSize - 1)

        return if (finalCol != -1 && list[finalRow][finalCol] == element) {
            Pair(finalRow, finalCol)
        } else {
            Pair(finalRow, -1)
        }
    }

    private fun binarySearch1DArray(list: IntArray, element: Int, low: Int, high: Int): Int {
        if (low <= high) {
            val mid = (low + high) / 2
            when {
                element > list[mid] -> {
                    return binarySearch1DArray(list, element, mid + 1, high)
                }
                element < list[mid] -> {
                    return binarySearch1DArray(list, element, low, mid - 1)
                }
                element == list[mid] -> {
                    return mid
                }
            }
        }
        return -1
    }
}