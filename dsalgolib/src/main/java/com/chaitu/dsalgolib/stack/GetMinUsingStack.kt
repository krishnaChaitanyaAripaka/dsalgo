package com.chaitu.dsalgolib.stack

import java.util.*

object GetMinUsingStack {
    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(38, 50, 90, 20, 18, 100, 70, 1)

        createGetMinDS(arr)

        printStacks()

        println("Popping till stack is empty")
        println("Get Min : ${getMin()}")

        removeFromStack()
    }

    private fun createGetMinDS(arr: IntArray) {
        for (i in arr.indices) {
            s1.add(arr[i])
            if (s2.empty() || (s2.peek() > arr[i])) {
                s2.add(arr[i])
            } else {
                s2.add(s2.peek())
            }
        }
    }

    private fun removeFromStack() {
        while (!s1.empty()) {
            pop()

            if (!s1.empty()) {
                println("Get Min : ${getMin()}")
            }
        }
    }

    private fun getMin(): Int {
        return s2.peek()
    }

    private fun pop(): Int {
        s1.pop()
        return s2.pop()
    }

    private fun printStacks() {
        println("Stack 1 : $s1")
        println("Stack 2 : $s2")
    }
}