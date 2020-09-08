package com.chaitu.dsalgolib.string

import java.util.*

object FindTwoStringAreAnagrams {
    @JvmStatic
    fun main(args: Array<String>) {
        val s1 = "silent"
        val s2 = "listen"

        print("Are strings \'$s1\' & \'$s2\' anagrams : ${isAnagram(s1, s2)}")
    }

    private fun isAnagram(s1: String, s2: String): Boolean {
        if (s1 == null || s2 == null) {
            return false
        }

        if (s1.length != s2.length) {
            return false
        }

        val count = 256
        val intArray1 = IntArray(count)
        Arrays.fill(intArray1, 0)
        val intArray2 = IntArray(count)
        Arrays.fill(intArray2, 0)
        for (i in s1.indices) {
            intArray1[s1[i].toInt()]++
            intArray2[s2[i].toInt()]++
        }

        for (i in 0 until count) {
            if (intArray1[i] != intArray2[i]) {
                return false
            }
        }

        return true
    }
}