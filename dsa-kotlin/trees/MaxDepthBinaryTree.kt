/**
 * Problem: Maximum Depth of Binary Tree
 * Find the maximum depth (number of nodes along the longest path from root to leaf).
 *
 * Approach: Recursively compute depth as 1 + max(leftDepth, rightDepth).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height (O(log n) balanced, O(n) skewed)
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val leftDepth = maxDepth(root.left)
    val rightDepth = maxDepth(root.right)
    return 1 + maxOf(leftDepth, rightDepth)
}

fun main() {
    // Test Case 1: Balanced tree
    //       3
    //      / \
    //     9  20
    //       /  \
    //      15   7
    val root1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println("Test 1: [3, 9, 20, null, null, 15, 7]")
    println("Max Depth: ${maxDepth(root1)}")
    println("Expected: 3\n")

    // Test Case 2: Single node
    val root2 = TreeNode(1)
    println("Test 2: [1]")
    println("Max Depth: ${maxDepth(root2)}")
    println("Expected: 1\n")

    // Test Case 3: Left-skewed tree
    val root3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4)
            }
        }
    }
    println("Test 3: Left skewed [1, 2, 3, 4]")
    println("Max Depth: ${maxDepth(root3)}")
    println("Expected: 4")
}
