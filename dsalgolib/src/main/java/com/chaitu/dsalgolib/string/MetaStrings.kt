package com.chaitu.dsalgolib.string

/**
 * Check if two strings can become same after a swap in one string
 */
object MetaStrings {
    @JvmStatic
    fun main(args: Array<String>) {
//        val str1 = "geeks"
//        val str2 = "keegs"

//        val str1 = "rsting"
//        val str2 = "string"

        val str1 = "Converse"
        val str2 = "Conserve"

        val result = if (isMeta(str1, str2)) "Meta Strings" else "Not Meta Strings"

        print("$str1 and $str2 are : $result")
    }

    private fun isMeta(str1: String, str2: String): Boolean {
        if (str1 == null || str1 == null) {
            return false
        }

        if (str1.length != str2.length) {
            return false
        }

        var mismatchCount = 0
        val hasSet = HashSet<Char>()
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                hasSet.add(str1[i])
                hasSet.add(str2[i])
                mismatchCount++
            }

            if (mismatchCount > 2) {
                return false
            }
        }

        return hasSet.size == 2
    }
}