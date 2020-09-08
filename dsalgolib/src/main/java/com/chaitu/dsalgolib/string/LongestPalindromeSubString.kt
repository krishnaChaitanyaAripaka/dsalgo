package com.chaitu.dsalgolib.string

object LongestPalindromeSubString {

    var resultStart: Int = 0
    var resultLength: Int = 0

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestPalindromeSubString("AGBDBA"))
    }

    private fun longestPalindromeSubString(s: String): String {
        if (s.length < 2) {
            return s
        }

        for (start in s.indices) {
            expandFromMiddle(s, start, start)
            expandFromMiddle(s, start, start + 1)
        }

        return s.substring(resultStart, resultStart + resultLength)
    }

    private fun expandFromMiddle(s: String, st: Int, en: Int) {
        var begin = st
        var end = en
        while (begin >= 0 && end < s.length && s[begin] == s[end]) {
            begin -= 1
            end += 1
        }

        if (resultLength < end - begin - 1) {
            resultStart = begin + 1
            resultLength = end - begin - 1
        }
    }
}