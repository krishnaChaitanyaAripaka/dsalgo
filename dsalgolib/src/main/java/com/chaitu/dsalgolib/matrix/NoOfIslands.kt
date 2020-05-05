package com.chaitu.dsalgolib.matrix

object NoOfIslands {
    @JvmStatic
    fun main(args: Array<String>) {
        val list =
            arrayOf(
                charArrayOf(' ', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' '),
                charArrayOf(' ', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
                charArrayOf(' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' '),
                charArrayOf(' ', ' ', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' '),
                charArrayOf('x', 'x', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' '),
                charArrayOf(' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', 'x', ' '),
                charArrayOf(' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', 'x', 'x'),
                charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
                charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
            )

        println("No of Islands : ${getIslands(list)}")
    }

    private fun getIslands(list: Array<CharArray>): Int {
        val rowSize = list.size
        val colSize = list[0].size

        var count = 0
        for (i in 0 until rowSize) {
            for (j in 0 until colSize) {
                if (list[i][j] == 'x') {
                    if ((i == 0 || list[i - 1][j] != 'x') && (j == 0 || list[i][j - 1] != 'x')) {
                        count++
                    }
                }
            }
        }
        return count
    }
}