package com.chaitu.dsalgolib.array

object CountDistinctNumberInWindow {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 2, 1, 3, 4, 2, 3)
        val k = 4

        countDistinctNumberInWindow(arr, k)
    }

    private fun countDistinctNumberInWindow(arr: IntArray, k: Int) {
        val hashMap = HashMap<Int, Int>()
        for (i in 0 until k) {
            hashMap[arr[i]] = (hashMap[arr[i]] ?: 0) + 1
        }
        print(hashMap.size)

        for (i in 1..arr.size - k) {
            val j = i + k - 1
            var countOfStartWindow = hashMap[arr[i - 1]] ?: 0
            if (countOfStartWindow > 1) {
                hashMap[arr[i - 1]] = countOfStartWindow - 1
            } else {
                hashMap.remove(arr[i - 1])
            }

            hashMap[arr[j]] = (hashMap[arr[i]] ?: 0) + 1
            print(hashMap.size)
        }
    }
}