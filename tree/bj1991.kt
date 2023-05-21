import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1991 트리순회
*/

class Node(val value: Char, var left: Node? = null, var right: Node? = null)

fun preorder(node: Node?) {
    if (node == null) return
    print(node.value)
    preorder(node.left)
    preorder(node.right)
}

fun inorder(node: Node?) {
    if (node == null) return
    inorder(node.left)
    print(node.value)
    inorder(node.right)
}

fun postorder(node: Node?) {
    if (node == null) return
    postorder(node.left)
    postorder(node.right)
    print(node.value)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val nodes = mutableMapOf<Char, Node>()

    repeat(n) {
        val (value, left, right) = readLine().split(" ")
        val parentNode = nodes.getOrPut(value[0]) { Node(value[0]) }

        if (left != ".")
            parentNode.left = nodes.getOrPut(left[0]) { Node(left[0]) }

        if (right != ".")
            parentNode.right = nodes.getOrPut(right[0]) { Node(right[0]) }
    }

    val root = nodes.values.first()
    preorder(root)
    println()
    inorder(root)
    println()
    postorder(root)
}
