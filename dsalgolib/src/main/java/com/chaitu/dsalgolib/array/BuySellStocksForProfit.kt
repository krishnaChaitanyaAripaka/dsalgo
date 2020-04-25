package com.chaitu.dsalgolib.array

object BuySellStocksForProfit {
    @JvmStatic
    fun main(args: Array<String>) {
        val stocks = arrayOf(1, 5, 2, 3, 7, 6, 4, 1, 1)

        maxProfitBuySellStocks(stocks)
    }

    private fun maxProfitBuySellStocks(stocks: Array<Int>) {
        var maxProfit = 0
        var buyIndex = 0
        for (index in 1 until stocks.size) {
            if (stocks[index] < stocks[index - 1]) {
                maxProfit += stocks[index - 1] - stocks[buyIndex]
                buyIndex = index
            } else if (index == stocks.size - 1 && stocks[index] > stocks[index - 1]) {
                maxProfit += stocks[index] - stocks[buyIndex]
            }
        }

        println("Max Profit : $maxProfit")
    }
}