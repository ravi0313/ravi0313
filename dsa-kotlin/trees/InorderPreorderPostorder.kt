/**
 * Problem: Tree Traversals (DFS)
 * Implement Inorder, Preorder, and Postorder traversals recursively.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height of tree
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun inorderTraversal(node: TreeNode?, result: MutableList<Int> = mutableListOf()): List<Int> {
    if (node != null) {
        inorderTraversal(node.left, result)
        result.add(node.value)
        inorderTraversal(node.right, result)
    }
    return result
}

fun preorderTraversal(node: TreeNode?, result: MutableList<Int> = mutableListOf()): List<Int> {
    if (node != null) {
        result.add(node.value)
        preorderTraversal(node.left, result)
        preorderTraversal(node.right, result)
    }
    return result
}

fun postorderTraversal(node: TreeNode?, result: MutableList<Int> = mutableListOf()): List<Int> {
    if (node != null) {
        postorderTraversal(node.left, result)
        postorderTraversal(node.right, result)
        result.add(node.value)
    }
    return result
}

fun main() {
    // Build test tree:
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }
    
    println("Tree Structure:")
    println("       1")
    println("      / \\")
    println("     2   3")
    println("    / \\")
    println("   4   5\n")
    
    val inorder = inorderTraversal(root)
    val preorder = preorderTraversal(root)
    val postorder = postorderTraversal(root)
    
    println("Test Case 1: Binary Tree")
    println("Inorder (Left-Root-Right):   $inorder")
    println("Expected:                     [4, 2, 5, 1, 3]")
    println("Preorder (Root-Left-Right):  $preorder")
    println("Expected:                     [1, 2, 4, 5, 3]")
    println("Postorder (Left-Right-Root): $postorder")
    println("Expected:                     [4, 5, 2, 3, 1]\n")
    
    // Test Case 2: Single node
    val root2 = TreeNode(10)
    println("Test Case 2: Single Node")
    println("Inorder:   ${inorderTraversal(root2)}")
    println("Preorder:  ${preorderTraversal(root2)}")
    println("Postorder: ${postorderTraversal(root2)}")
    println("Expected: [10] for all\n")
    
    // Test Case 3: Linear tree (left skewed)
    val root3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    println("Test Case 3: Left Skewed Tree")
    println("Inorder:   ${inorderTraversal(root3)}")
    println("Preorder:  ${preorderTraversal(root3)}")
    println("Postorder: ${postorderTraversal(root3)}")
    println("Expected Inorder:   [3, 2, 1]")
    println("Expected Preorder:  [1, 2, 3]")
    println("Expected Postorder: [3, 2, 1]")
}
