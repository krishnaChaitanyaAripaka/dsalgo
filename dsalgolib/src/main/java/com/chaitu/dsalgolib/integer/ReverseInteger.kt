package com.chaitu.dsalgolib.integer

import kotlin.math.abs

object ReverseInteger {
    @JvmStatic
    fun main(args: Array<String>) {
        val value = 2147447412
        println(reverseInteger(value))
    }

    private fun reverseInteger(num: Int): Int {
        var result = 0
        val isNegative = num < 0
        var valueInternal = abs(num)

        while (valueInternal != 0) {
            if (result > Int.MAX_VALUE / 10) {
                return 0
            } else if (result < Int.MIN_VALUE / 10) {
                return 0
            }

            result = result * 10 + valueInternal % 10
            valueInternal /= 10
        }


        return if (isNegative) -result
        else result
    }
}