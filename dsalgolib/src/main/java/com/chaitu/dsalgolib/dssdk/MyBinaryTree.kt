package com.chaitu.dsalgolib.dssdk

class MyBinaryTree<T> {

    var root: Node<T>? = null

    class Node<T>(var element: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null
        var depth: Int = 0
    }

    fun insert(element: T) {
        if (root == null) {
            var nodeTemp = Node(element)
            root = nodeTemp
        } else {
            insert(root, element)
        }
    }

    private fun insert(node: Node<T>?, element: T) {
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

    fun insertLeftOf(nodeValue: T, newValue: T) {
        findNode(nodeValue)?.let {
            it.left = Node(newValue)
        }
    }

    fun insertRightOf(nodeValue: T, newValue: T) {
        findNode(nodeValue)?.let {
            it.right = Node(newValue)
        }
    }

    private fun findNode(value: T): Node<T>? {
        return find(root, value)
    }

    private fun find(node: Node<T>?, value: T): Node<T>? {
        if (node != null) {
            if (node.element == value) {
                return node
            }

            val leftNode = find(node?.left, value)
            return leftNode ?: find(node?.right, value)
        }
        return null
    }
}