package com.chaitu.dsalgolib.string

import java.util.*

/**
 * DS : Stack
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
object RemoveAdjacentCharacters {
    @JvmStatic
    fun main(args: Array<String>) {
//        val str = "abcccbaaddd"
//        val str = "Hey guys how are you?"
        val str = "Hell"

        println("After removing adjacent characters the result is : ${removeAdjacentCharacters(str)}")
    }

    private fun removeAdjacentCharacters(str: String): String {
        var stack = Stack<Char>()
        var popChar = ' '
        var duplicateExists = false

        for (i in str.indices) {
            if (popChar != str[i]) {
                if (stack.isNotEmpty() && stack.peek() == str[i]) {
                    popChar = stack.pop()
                    duplicateExists = true
                } else {
                    stack.push(str[i])
                }
            }
        }

        if (stack.empty()) {
            return ""
        }

        if (!duplicateExists) {
            return str
        }

        val iterator = stack.iterator()
        val result = StringBuilder()
        while (iterator.hasNext()) {
            result.append(iterator.next())
        }

        return result.toString().reversed()
    }
}