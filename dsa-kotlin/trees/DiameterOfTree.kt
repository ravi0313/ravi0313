/**
 * Problem: Diameter of Binary Tree
 * Find the length of the diameter — the longest path between any two nodes.
 * The path may or may not pass through the root. Length = number of edges.
 *
 * Approach: For each node, the potential diameter is leftHeight + rightHeight.
 * Track global max while recursing for height.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var maxDiameter = 0

    fun height(node: TreeNode?): Int {
        if (node == null) return 0
        val leftH = height(node.left)
        val rightH = height(node.right)
        maxDiameter = maxOf(maxDiameter, leftH + rightH)
        return 1 + maxOf(leftH, rightH)
    }

    height(root)
    return maxDiameter
}

fun main() {
    // Test Case 1: Diameter passes through root
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }
    println("Test 1: [1, 2, 3, 4, 5]")
    println("Diameter: ${diameterOfBinaryTree(root1)}")
    println("Expected: 3  (path 4 → 2 → 1 → 3  or  5 → 2 → 1 → 3)\n")

    // Test Case 2: Single node
    val root2 = TreeNode(1)
    println("Test 2: [1]")
    println("Diameter: ${diameterOfBinaryTree(root2)}")
    println("Expected: 0\n")

    // Test Case 3: Diameter does NOT pass through root
    //       1
    //      /
    //     2
    //    / \
    //   3   4
    //  /     \
    // 5       6
    val root3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply { left = TreeNode(5) }
            right = TreeNode(4).apply { right = TreeNode(6) }
        }
    }
    println("Test 3: Deep left subtree")
    println("Diameter: ${diameterOfBinaryTree(root3)}")
    println("Expected: 4  (path 5 → 3 → 2 → 4 → 6)")
}
