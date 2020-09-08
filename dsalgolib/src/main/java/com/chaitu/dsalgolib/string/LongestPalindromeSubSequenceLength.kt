package com.chaitu.dsalgolib.string

import com.chaitu.dsalgolib.utils.print

object LongestPalindromeSubSequenceLength {
    @JvmStatic
    fun main(args: Array<String>) {
//        val str = "ABBDCACB"
        //EXPECTED O/P : 5

//        val str = "BBABACBCAA"
        //EXPECTED O/P : 7

//        val str = "BBAB"
        //EXPECTED O/P : 3

        val str = "AGBDBA"
        //EXPECTED O/P : 5

        longestPalindromeSubsequence(str)
    }

    private fun longestPalindromeSubsequence(str: String) {
        val array = Array(str.length) { IntArray(str.length) }
        for (i in str.indices) {
            array[i][i] = 1
        }

        for (l in 2 until str.length + 1) {
            for (i in 0 until str.length - l + 1) {
                var j = i + l - 1
                if (l == 2 && str[i] == str[j]) {
                    array[i][j] = 2
                } else if (str[i] == str[j]) {
                    array[i][j] = array[i + 1][j - 1] + 2
                } else {
                    array[i][j] = maxOf(array[i + 1][j], array[i][j - 1])
                }
            }
        }
        array.print()
    }
}