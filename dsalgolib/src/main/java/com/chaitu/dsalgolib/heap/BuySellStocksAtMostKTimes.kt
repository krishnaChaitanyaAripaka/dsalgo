package com.chaitu.dsalgolib.heap

import java.util.*

object BuySellStocksAtMostKTimes {
    @JvmStatic
    fun main(args: Array<String>) {
        val stocks = arrayOf(1, 5, 2, 3, 15, 6, 4, 1, 1, 8, 7, 22, 5, 10)
        var k = 2

        buySellStocksAtMostKTimes(stocks, k)
    }

    private fun buySellStocksAtMostKTimes(stocks: Array<Int>, k: Int) {
        var buyIndex = 0
        val queue = PriorityQueue<Int>()
        for (index in 1 until stocks.size) {
            if (stocks[index] < stocks[index - 1]) {
                val profit = stocks[index - 1] - stocks[buyIndex]
                if (profit > 0) {
                    println("Profit : $profit")
                    addToQueue(queue, profit, k)
                }
                buyIndex = index
            } else if (index == stocks.size - 1 && stocks[index] > stocks[index - 1]) {
                val profit = stocks[index] - stocks[buyIndex]
                if (profit > 0) {
                    println("Profit : $profit")
                    addToQueue(queue, profit, k)
                }
            }
        }

        println("Queue : $queue")
    }

    private fun addToQueue(queue: Queue<Int>, value: Int, k: Int) {
        if (queue.size < k) {
            queue.add(value)
        } else if (queue.peek() < value) {
            queue.poll()
            queue.add(value)
        }
    }
}