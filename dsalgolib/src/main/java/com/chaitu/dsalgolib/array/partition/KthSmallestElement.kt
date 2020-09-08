package com.chaitu.dsalgolib.array.partition

object KthSmallestElement {
    @JvmStatic
    fun main(args: Array<String>) {
        val k = 3
        val list = arrayOf(4, 7, 10, 6, 1, 8, 9, 20, 5)

        findKthSmallestElement(list, k - 1, 0, list.size - 1)
    }

    private fun findKthSmallestElement(list: Array<Int>, k: Int, low: Int, high: Int) {
        if (low <= high) {
            var pivotIndex = partition(list, low, high)
            when {
                pivotIndex == k -> {
                    print(list[k])
                }
                pivotIndex < k -> {
                    findKthSmallestElement(list, k, pivotIndex + 1, high)
                }
                pivotIndex > k -> {
                    findKthSmallestElement(list, k, low, pivotIndex - 1)
                }
            }
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