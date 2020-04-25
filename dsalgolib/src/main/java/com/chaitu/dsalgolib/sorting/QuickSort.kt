package com.chaitu.dsalgolib.sorting

object QuickSort {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = arrayOf(3, 2, 1, 5, 6, 4)
        quickSort(list, 0, list.size - 1)

        println(list)
    }

    private fun quickSort(list: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            val pivotIndex =
                partition(list, low, high)
            quickSort(list, low, pivotIndex - 1)
            quickSort(list, pivotIndex + 1, high)
        }
    }

    private fun partition(list: Array<Int>, low: Int, high: Int): Int {
        val pivotValue = list[high]
        var i = low - 1
        for (j in low until high) {
            if (list[j] < pivotValue) {
                i++
                swap(list, i, j)
            }
        }
        i++
        swap(list, i, high)
        return i
    }

    private fun swap(list: Array<Int>, index1: Int, index2: Int) {
        if (index1 == index2) {
            return
        }
        var temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }
}
