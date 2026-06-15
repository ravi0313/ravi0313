/**
 * Problem: Lowest Common Ancestor of a BST
 * Given a Binary Search Tree and two nodes p and q, find their Lowest Common Ancestor (LCA).
 * LCA is defined as the deepest node that is an ancestor of both p and q.
 *
 * Approach: In a BST, if both p and q are less than root, go left. If both greater, go right.
 * Otherwise, root is the LCA.
 *
 * Time Complexity: O(log n) average, O(n) worst case
 * Space Complexity: O(1) iterative
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int): TreeNode? {
    var node = root
    while (node != null) {
        node = when {
            p < node.value && q < node.value -> node.left
            p > node.value && q > node.value -> node.right
            else -> return node
        }
    }
    return null
}

fun main() {
    // Build BST:
    //        6
    //       / \
    //      2   8
    //     / \ / \
    //    0  4 7  9
    //      / \
    //     3   5
    val root = TreeNode(6).apply {
        left = TreeNode(2).apply {
            left = TreeNode(0)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(5)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    println("BST: [6, 2, 8, 0, 4, 7, 9, 3, 5]")

    val lca1 = lowestCommonAncestor(root, 2, 8)
    println("\nLCA(2, 8) = ${lca1?.value}")
    println("Expected: 6")

    val lca2 = lowestCommonAncestor(root, 2, 4)
    println("\nLCA(2, 4) = ${lca2?.value}")
    println("Expected: 2")

    val lca3 = lowestCommonAncestor(root, 3, 5)
    println("\nLCA(3, 5) = ${lca3?.value}")
    println("Expected: 4")
}
