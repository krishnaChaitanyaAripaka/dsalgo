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
        val charArray1 = IntArray(count)
        Arrays.fill(charArray1, 0)
        val charArray2 = IntArray(count)
        Arrays.fill(charArray2, 0)
        for (i in s1.indices) {
            charArray1[s1[i].toInt()]++
            charArray2[s2[i].toInt()]++
        }

        for (i in 0 until count) {
            if (charArray1[i] != charArray2[i]) {
                return false
            }
        }

        return true
    }
}