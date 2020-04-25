package com.chaitu.dsalgolib.heap

object MaxHeapMinHeap {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(44, 11, 22, 55, 33, 66)

//        mainMaxHeap(arr)
        mainMinHeap(arr)
    }

    private fun mainMinHeap(arr: IntArray) {
        val minHeap = minHeap(arr)
        println("Min Heap : $minHeap")

        popMinHeap(minHeap)
        println("Popping Min Heap : $minHeap")
    }

    private fun mainMaxHeap(arr: IntArray) {
        val maxHeap = maxHeap(arr)
        println("Max Heap : $maxHeap")

        popMaxHeap(maxHeap)
        println("Popping Max Heap : $maxHeap")
    }

    /************************** Heap Creation **************************/

    private fun maxHeap(arr: IntArray): ArrayList<Int> {
        var heap = ArrayList<Int>()
        for (i in arr.indices) {
            insertIntoHeap(heap, arr[i], true)
        }
        return heap
    }


    private fun minHeap(arr: IntArray): ArrayList<Int> {
        val heap = ArrayList<Int>()
        for (i in arr.indices) {
            insertIntoHeap(heap, arr[i], false)
        }
        return heap
    }

    /************************** Insertion **************************/

    private fun insertIntoHeap(heap: ArrayList<Int>, value: Int, maxHeap: Boolean) {
        heap.add(value)
        heapifyWhileInsertion(heap, maxHeap)
    }

    private fun heapifyWhileInsertion(heap: ArrayList<Int>, maxHeap: Boolean) {
        var childIndex = heap.size - 1
        var parentIndex =
            getParentIndex(childIndex)
        while (isToHeapifyInsertion(parentIndex, maxHeap, heap, childIndex)) {
            swap(heap, childIndex, parentIndex)
            childIndex = parentIndex
            parentIndex = getParentIndex(childIndex)
        }
    }

    private fun isToHeapifyInsertion(
        parentIndex: Int,
        maxHeap: Boolean,
        heap: ArrayList<Int>,
        childIndex: Int
    ): Boolean {
        return if (parentIndex < 0) {
            false
        } else {
            if (maxHeap) {
                heap[childIndex] > heap[parentIndex]
            } else {
                heap[childIndex] < heap[parentIndex]
            }
        }
    }

    /************************** Deletion **************************/

    private fun popMinHeap(minHeap: ArrayList<Int>) {
        val lastIndex = minHeap.size - 1
        minHeap[0] = minHeap[lastIndex]
        minHeap.removeAt(lastIndex)
        heapifyWhileDeleting(minHeap, false, 0)
    }

    private fun heapifyWhileDeleting(heap: ArrayList<Int>, maxHeap: Boolean, parentIndex: Int) {
        var leftChild = getLeftChildIndex(parentIndex)
        var rightChild = getRightChildIndex(parentIndex)

        if (leftChild >= heap.size) {
            return
        }
        val childIndex: Int =
            if (rightChild < heap.size) {
                if (maxHeap)
                    if (heap[leftChild] > heap[rightChild]) leftChild else rightChild
                else
                    if (heap[leftChild] < heap[rightChild]) leftChild else rightChild
            } else {
                leftChild
            }

        while (isToHeapifyDeletion(maxHeap, heap, parentIndex, childIndex)) {
            swap(heap, parentIndex, childIndex)
            heapifyWhileDeleting(heap, maxHeap, childIndex)
        }
    }

    private fun isToHeapifyDeletion(
        maxHeap: Boolean,
        heap: ArrayList<Int>,
        parentIndex: Int,
        childIndex: Int
    ): Boolean {
        return if (maxHeap) {
            heap[parentIndex] < heap[childIndex]
        } else {
            heap[parentIndex] > heap[childIndex]
        }
    }

    private fun popMaxHeap(maxHeap: ArrayList<Int>) {
        val lastIndex = maxHeap.size - 1
        maxHeap[0] = maxHeap[lastIndex]
        maxHeap.removeAt(lastIndex)
        heapifyWhileDeleting(maxHeap, true, 0)
    }

    /************************** Common Methods **************************/

    private fun getParentIndex(childIndex: Int) =
        if (childIndex % 2 == 0) childIndex / 2 - 1 else childIndex / 2

    private fun getLeftChildIndex(parent: Int) = parent * 2 + 1

    private fun getRightChildIndex(parent: Int) = parent * 2 + 2

    private fun swap(heap: ArrayList<Int>, childIndex: Int, parentIndex: Int) {
        var temp = heap[childIndex]
        heap[childIndex] = heap[parentIndex]
        heap[parentIndex] = temp
    }
}