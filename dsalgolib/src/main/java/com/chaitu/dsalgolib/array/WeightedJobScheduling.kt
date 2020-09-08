package com.chaitu.dsalgolib.array

import java.util.*

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that
 * jobs in subset do not overlap.
 */
class WeightedJobSchedulingMaximumProfit {
    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     * @param jobs
     * @return
     */

    class Job(var start: Int, var end: Int, var profit: Int)

    internal class FinishTimeComparator : Comparator<Job> {
        override
        fun compare(arg0: Job, arg1: Job): Int {
            return if (arg0.end <= arg1.end) {
                -1
            } else {
                1
            }
        }
    }

    fun maximum(jobs: Array<Job>): Int {
        val T = IntArray(jobs.size)
        val comparator = FinishTimeComparator()
        Arrays.sort(jobs, comparator)
        T[0] = jobs[0]!!.profit
        for (i in 1 until jobs.size) {
            T[i] = Math.max(jobs[i]!!.profit, T[i - 1])
            for (j in i - 1 downTo 0) {
                if (jobs[j]!!.end <= jobs[i]!!.start) {
                    T[i] = Math.max(T[i], jobs[i]!!.profit + T[j])
                    break
                }
            }
        }
        var maxVal = Int.MIN_VALUE
        for (`val` in T) {
            if (maxVal < `val`) {
                maxVal = `val`
            }
        }
        return maxVal
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val jobs = mutableListOf<Job>()
            jobs.add(Job(1, 3, 5))
            jobs.add(Job(2, 5, 6))
            jobs.add(Job(4, 6, 5))
            jobs.add(Job(6, 7, 4))
            jobs.add(Job(5, 8, 11))
            jobs.add(Job(7, 9, 2))
            val mp = WeightedJobSchedulingMaximumProfit()
            println(mp.maximum(jobs.toTypedArray()))
        }
    }
}