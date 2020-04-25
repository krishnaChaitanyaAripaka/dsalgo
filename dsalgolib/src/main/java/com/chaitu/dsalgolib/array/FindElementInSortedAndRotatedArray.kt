package com.chaitu.dsalgolib.array


object FindElementInSortedAndRotatedArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(5, 6, 7, 8, 9, 10, 1, 2, 4)
        val n = arr.size
        val key = 1

        println("Element $key is at index : ${searchElement(arr, key)}")
    }

    private fun searchElement(arr: IntArray, key: Int): Int {
        val pivot = findPivot(arr, 0, arr.size - 1)

        //array is not rotated
        if (pivot == -1) {
            return binarySearch(arr, 0, arr.size - 1, key)
        }

        return when {
            arr[pivot] == key -> {
                return pivot
            }
            arr[0] < key -> {
                binarySearch(arr, 0, pivot - 1, key)
            }
            else -> {
                binarySearch(arr, pivot + 1, arr.size - 1, key)
            }
        }
    }

    private fun findPivot(arr: IntArray, low: Int, high: Int): Int { // base cases
        if (high < low) return -1
        if (high == low) return low
        var mid = (low + high) / 2
        if (mid < high && arr[mid] > arr[mid + 1]) return mid
        if (mid > low && arr[mid] < arr[mid - 1]) return mid - 1
        return if (arr[low] >= arr[mid]) {
            findPivot(arr, low, mid - 1)
        } else {
            findPivot(arr, mid + 1, high)
        }
    }

    private fun binarySearch(arr: IntArray, low: Int, high: Int, key: Int): Int {
        if (low <= high) {
            val mid = (low + high) / 2
            return when {
                key > arr[mid] -> binarySearch(arr, mid + 1, high, key)
                key < arr[mid] -> binarySearch(arr, low, mid - 1, key)
                else -> mid
            }
        }
        return -1
    }
}