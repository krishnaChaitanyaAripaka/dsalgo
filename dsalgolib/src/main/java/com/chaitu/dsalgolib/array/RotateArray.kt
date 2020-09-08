package com.chaitu.dsalgolib.array

object RotateArray {
    @JvmStatic
    fun main(args: Array<String>) {

        val array = intArrayOf(1, 3, 5, 7, 9)
        println(leftRotate(array, 3))
    }

    private fun leftRotate(arr: IntArray, k: Int) { /* To get the starting point of
        rotated array */
        val n = arr.size
        val mod = k % n
        // Prints the rotated array from // start position
        for (i in 0 until n)
            print(arr[(i + mod) % n].toString() + " ")
        println()
    }
}