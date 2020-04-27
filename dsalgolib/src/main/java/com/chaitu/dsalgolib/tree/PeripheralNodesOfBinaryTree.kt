package com.chaitu.dsalgolib.tree

import com.chaitu.dsalgolib.dssdk.MyBinaryTree

object PeripheralNodesOfBinaryTree {
    @JvmStatic
    fun main(args: Array<String>) {
        val tree = MyBinaryTree<Char>()
        tree.insert('A')
        tree.insertLeftOf('A', 'B')
        tree.insertLeftOf('B', 'C')
        tree.insertLeftOf('C', 'D')
        tree.insertRightOf('B', 'E')
        tree.insertLeftOf('E', 'F')
        tree.insertLeftOf('F', 'G')
        tree.insertRightOf('G', 'H')
        tree.insertRightOf('E', 'I')

        peripheralNodes(tree.root)
    }

    private fun peripheralNodes(node: MyBinaryTree.Node<Char>?) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                print(node.element)
            }
            peripheralNodes(node.left)
            peripheralNodes(node.right)
        }
    }
}