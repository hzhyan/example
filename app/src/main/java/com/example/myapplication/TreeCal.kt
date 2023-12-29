package com.example.myapplication

class TreeCal {
// 4   9   5  1   0

    var sum: Int = 0

    fun cal(node: Node): Int {
        calNode(node, 0)
        return sum
    }

    private fun calNode(node: Node?, current: Int) {
        if (node == null) {
            sum += current
            return
        }
        val cur = (current * 10 + node.element)
        calNode(node.leftNode, cur)
        calNode(node.rightNode, cur)
    }

}

class Node {
    val element: Int = 0
    val leftNode: Node? = null
    val rightNode: Node? = null
}