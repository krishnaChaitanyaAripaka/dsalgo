package com.chaitu.dsalgolib.tree

object BSTFromPreOrderTraversal {
    @JvmStatic
    fun main(args: Array<String>) {
        bstFromPreOrder(intArrayOf(8, 5, 1, 7, 10, 12))
    }

    private fun bstFromPreOrder(preOrder: IntArray): TreeNode? {
        var root = TreeNode(preOrder[0])
        for (i in 1 until preOrder.size) {
            var ti = root

            while (ti != null) {
                if (preOrder[i] < ti.`val`) {
                    if (ti.left == null) {
                        ti.left = TreeNode(preOrder[i])
                        break
                    } else {
                        ti = ti.left!!
                    }
                } else {
                    if (ti.right == null) {
                        ti.right = TreeNode(preOrder[i])
                        break
                    } else {
                        ti = ti.right!!
                    }
                }
            }
        }
        return root
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
