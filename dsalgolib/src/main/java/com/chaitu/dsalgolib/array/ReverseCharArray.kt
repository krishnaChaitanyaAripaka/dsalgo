package com.chaitu.dsalgolib.array

object ReverseCharArray {
    @JvmStatic
    fun main(args: Array<String>) {

        println(
            reverseCharArray(
                charArrayOf(
                    'I',
                    'N',
                    'T',
                    'E',
                    'R',
                    'V',
                    'I',
                    'E',
                    'W',
                    'P',
                    'R',
                    'E',
                    'P',
                    'A',
                    'R',
                    'A',
                    'T',
                    'I',
                    'O',
                    'N'
                )
            )
        )
    }

    private fun reverseCharArray(charArray: CharArray): CharArray {
        var temp = ' '
        var start = 0
        val size = charArray.size
        while (start < size / 2) {
            temp = charArray[size - 1 - start]
            charArray[size - 1 - start] = charArray[start]
            charArray[start] = temp
            start++
        }
        return charArray
    }
}