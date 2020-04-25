package com.chaitu.dsalgolib.utils

fun <T> Array<T>.print() {
    print("[")
    for (i in indices) {
        val item = get(i)

        if (item is IntArray) {
            item.print()
        }
        if (i != size - 1) {
            println()
        }
    }
    print("]")
}


fun IntArray.print() {
    print("[")
    for (i in indices) {
        print(get(i))
    }
    print("]")
}