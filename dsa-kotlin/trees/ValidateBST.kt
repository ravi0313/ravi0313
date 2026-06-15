/**
 * Problem: Validate Binary Search Tree
 * Determine if a binary tree is a valid BST.
 * A valid BST requires all left subtree values < root < all right subtree values.
 *
 * Approach: Pass valid range (min, max) down recursively. Each node must lie within range.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun isValidBST(node: TreeNode?, min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE): Boolean {
    if (node == null) return true
    if (node.value.toLong() <= min || node.value.toLong() >= max) return false
    return isValidBST(node.left, min, node.value.toLong()) &&
           isValidBST(node.right, node.value.toLong(), max)
}

fun main() {
    // Test Case 1: Valid BST
    //     2
    //    / \
    //   1   3
    val root1 = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }
    println("Test 1: [2, 1, 3]")
    println("Is Valid BST: ${isValidBST(root1)}")
    println("Expected: true\n")

    // Test Case 2: Invalid BST
    //     5
    //    / \
    //   1   4
    //      / \
    //     3   6
    val root2 = TreeNode(5).apply {
        left = TreeNode(1)
        right = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(6)
        }
    }
    println("Test 2: [5, 1, 4, null, null, 3, 6]")
    println("Is Valid BST: ${isValidBST(root2)}")
    println("Expected: false (4 < 5 but is right child)\n")

    // Test Case 3: Edge case — equal values not allowed
    //     2
    //    / \
    //   2   2
    val root3 = TreeNode(2).apply {
        left = TreeNode(2)
        right = TreeNode(2)
    }
    println("Test 3: [2, 2, 2] (duplicates)")
    println("Is Valid BST: ${isValidBST(root3)}")
    println("Expected: false (BST requires strict inequality)")
}
