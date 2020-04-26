package com.chaitu.dsalgolib.dssdk

import java.util.concurrent.ConcurrentLinkedQueue

class MinDepthBinaryTree {

    var root: Node? = null

    class Node(var element: Int) {
        var left: Node? = null
        var right: Node? = null
        var depth: Int = 0
    }

    fun insert(element: Int) {
        if (root == null) {
            var nodeTemp = Node(element)
            root = nodeTemp
        } else {
            insert(root, element)
        }
    }

    private fun insert(node: Node?, element: Int) {
        when {
            node == null -> {
                return
            }
            node.left == null -> {
                var nodeTemp = Node(element)
                node.left = nodeTemp
            }
            node.right == null -> {
                var nodeTemp = Node(element)
                node.right = nodeTemp
            }
        }
    }

    fun insertLeftOf(nodeValue: Int, newValue: Int) {
        findNode(nodeValue)?.let {
            it.left = Node(newValue)
        }
    }

    fun insertRightOf(nodeValue: Int, newValue: Int) {
        findNode(nodeValue)?.let {
            it.right = Node(newValue)
        }
    }

    private fun findNode(value: Int): Node? {
        return find(root, value)
    }

    private fun find(node: Node?, value: Int): Node? {
        if (node != null) {
            if (node.element == value) {
                return node
            }

            val leftNode = find(node?.left, value)
            return leftNode ?: find(node?.right, value)
        }
        return null
    }

    fun minDepth(): Int {
        val queue = ConcurrentLinkedQueue<Node>()
        val node = root
        if (node != null) {
            queue.add(root)
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