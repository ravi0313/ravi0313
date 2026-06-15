/**
 * Problem: Symmetric Tree
 * Check if a binary tree is a mirror of itself (symmetric around its center).
 *
 * Approach: Two subtrees are mirrors if:
 *   - Their roots have the same value
 *   - The left subtree's right is a mirror of the right subtree's left (and vice versa)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun isSymmetric(root: TreeNode?): Boolean {
    return isMirror(root?.left, root?.right)
}

fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    return left.value == right.value &&
           isMirror(left.left, right.right) &&
           isMirror(left.right, right.left)
}

fun main() {
    // Test Case 1: Symmetric tree
    //       1
    //      / \
    //     2   2
    //    / \ / \
    //   3  4 4  3
    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(3)
        }
    }
    println("Test 1: [1, 2, 2, 3, 4, 4, 3]")
    println("Is Symmetric: ${isSymmetric(root1)}")
    println("Expected: true\n")

    // Test Case 2: Asymmetric tree
    //     1
    //    / \
    //   2   2
    //    \   \
    //     3   3
    val root2 = TreeNode(1).apply {
        left = TreeNode(2).apply { right = TreeNode(3) }
        right = TreeNode(2).apply { right = TreeNode(3) }
    }
    println("Test 2: [1, 2, 2, null, 3, null, 3]")
    println("Is Symmetric: ${isSymmetric(root2)}")
    println("Expected: false\n")

    // Test Case 3: Single node
    val root3 = TreeNode(1)
    println("Test 3: [1]")
    println("Is Symmetric: ${isSymmetric(root3)}")
    println("Expected: true")
}
