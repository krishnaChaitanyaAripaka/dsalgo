package com.chaitu.dsalgolib.tree

import com.chaitu.dsalgolib.dssdk.MinDepthBinaryTree

object FindMinDepthOfBinaryTree {
    @JvmStatic
    fun main(args: Array<String>) {
        var binaryTree = MinDepthBinaryTree()
        binaryTree.insert(1)
        binaryTree.insertLeftOf(1, 2)
        binaryTree.insertRightOf(1, 3)
        binaryTree.insertLeftOf(2, 4)
        binaryTree.insertLeftOf(3, 5)
        binaryTree.insertRightOf(3, 6)
        binaryTree.insertRightOf(5, 7)
        binaryTree.insertLeftOf(6, 8)

        println(binaryTree.minDepth())
    }
}