package com.chaitu.dsalgolib.array

import kotlin.math.abs

object MinTimeDifference {
    @JvmStatic
    fun main(args: Array<String>) {
        var list = arrayOf("03:45pm", "11:00am", "12:45pm", "03:25pm")
        println(getMinDifference(list))
    }

    private fun getMinDifference(args: Array<String>): Int {
        var min = Int.MAX_VALUE
        for (i in 0 until args.size - 1) {
            for (j in i + 1 until args.size) {
                val prev = args[i]
                val curr = args[j]
                val isPrevAm = prev.substring(5) == "am"
                val isCurrAm = curr.substring(5) == "am"
                var prevHour = prev.substring(0, 2).toInt()
                var currHour = curr.substring(0, 2).toInt()
                val prevMin = prev.substring(3, 5).toInt()
                val currMin = curr.substring(3, 5).toInt()
                if (!isPrevAm && prevHour < 12) {
                    prevHour += 12
                }
                if (!isCurrAm && currHour < 12) {
                    currHour += 12
                }
                var isCurrentGreater: Boolean
                isCurrentGreater = if (currHour == prevHour) {
                    currMin - prevMin > 0
                } else {
                    currHour - prevHour > 0
                }
                var result = abs(currHour - prevHour) * 60
                result += if (isCurrentGreater) currMin - prevMin else prevMin - currMin
                if (result < min) {
                    min = result
                }
            }
        }
        return min
    }
}