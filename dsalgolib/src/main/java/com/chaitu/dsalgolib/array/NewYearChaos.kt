package com.chaitu.dsalgolib.array

import java.util.*

object NewYearChaos {
    @JvmStatic
    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)

        val t = scan.nextLine().trim().toInt()

        for (tItr in 1..t) {
            val n = scan.nextLine().trim().toInt()

            val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

            minimumBribes(q)
        }
    }

    private fun minimumBribes(q: Array<Int>) {
        var swap = 0
        var bribes: Int
        var pos = 0
        for (i in q.indices.reversed()) {
            var j = 0
            bribes = q[pos] - pos++
            if (bribes > 2) {
                println("Too chaotic")
                return
            }
            if (q[i] - 2 > 0) {
                j = q[i] - 2
            }
            while (j <= i) {
                if (q[j] > q[i]) {
                    swap++
                }
                j++
            }
        }
        println(swap)
    }
}