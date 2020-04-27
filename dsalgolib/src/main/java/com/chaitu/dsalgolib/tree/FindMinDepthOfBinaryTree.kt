package com.chaitu.dsalgolib.tree

import com.chaitu.dsalgolib.dssdk.MyBinaryTree
import java.util.concurrent.ConcurrentLinkedQueue

object FindMinDepthOfBinaryTree {
    @JvmStatic
    fun main(args: Array<String>) {
        var binaryTree = MyBinaryTree<Int>()
        binaryTree.insert(1)
        binaryTree.insertLeftOf(1, 2)
        binaryTree.insertRightOf(1, 3)
        binaryTree.insertLeftOf(2, 4)
        binaryTree.insertLeftOf(3, 5)
        binaryTree.insertRightOf(3, 6)
        binaryTree.insertRightOf(5, 7)
        binaryTree.insertLeftOf(6, 8)

        println(minDepth(binaryTree.root))
    }

    private fun minDepth(node: MyBinaryTree.Node<Int>?): Int {
        val queue = ConcurrentLinkedQueue<MyBinaryTree.Node<Int>>()
        if (node != null) {
            queue.add(node)
            node.depth = 0

            while (queue.isNotEmpty()) {
                var currentNode = queue.remove()

                if (currentNode.left == null && currentNode.right == null) {
                    return currentNode.depth
                }

                if (currentNode.left != null) {
                    var depth = currentNode.depth
                    var queueNode = currentNode.left
                    queueNode?.depth = depth + 1
                    queue.add(queueNode)
                }

                if (currentNode.right != null) {
                    var depth = currentNode.depth
                    var queueNode = currentNode.right
                    queueNode?.depth = depth + 1
                    queue.add(queueNode)
                }
            }
        }
        return 0
    }
}