/**
 * Problem: Binary Search Tree Operations
 * Implement insert, search, and delete operations on a binary search tree.
 *
 * Time Complexity: O(log n) average case, O(n) worst case
 * Space Complexity: O(n)
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

class BinarySearchTree {
    private var root: TreeNode? = null
    
    fun insert(value: Int) {
        root = insertHelper(root, value)
    }
    
    private fun insertHelper(node: TreeNode?, value: Int): TreeNode {
        return if (node == null) {
            TreeNode(value)
        } else {
            when {
                value < node.value -> node.left = insertHelper(node.left, value)
                value > node.value -> node.right = insertHelper(node.right, value)
            }
            node
        }
    }
    
    fun search(value: Int): Boolean {
        return searchHelper(root, value)
    }
    
    private fun searchHelper(node: TreeNode?, value: Int): Boolean {
        return when {
            node == null -> false
            value == node.value -> true
            value < node.value -> searchHelper(node.left, value)
            else -> searchHelper(node.right, value)
        }
    }
    
    fun delete(value: Int) {
        root = deleteHelper(root, value)
    }
    
    private fun deleteHelper(node: TreeNode?, value: Int): TreeNode? {
        return if (node == null) {
            null
        } else when {
            value < node.value -> {
                node.left = deleteHelper(node.left, value)
                node
            }
            value > node.value -> {
                node.right = deleteHelper(node.right, value)
                node
            }
            else -> {
                // Node to delete found
                when {
                    node.left == null && node.right == null -> null
                    node.left == null -> node.right
                    node.right == null -> node.left
                    else -> {
                        // Both children exist - find in-order successor
                        var minRight = node.right
                        while (minRight?.left != null) {
                            minRight = minRight.left
                        }
                        node.value = minRight!!.value
                        node.right = deleteHelper(node.right, minRight.value)
                        node
                    }
                }
            }
        }
    }
    
    fun inorderTraversal(node: TreeNode? = root, result: MutableList<Int> = mutableListOf()): List<Int> {
        if (node != null) {
            inorderTraversal(node.left, result)
            result.add(node.value)
            inorderTraversal(node.right, result)
        }
        return result
    }
}

fun main() {
    val bst = BinarySearchTree()
    
    // Insert values
    val values = listOf(50, 30, 70, 20, 40, 60, 80)
    println("Inserting: $values")
    values.forEach { bst.insert(it) }
    
    // Search operations
    println("\nSearch Operations:")
    println("Search 40: ${bst.search(40)} (Expected: true)")
    println("Search 25: ${bst.search(25)} (Expected: false)")
    println("Search 80: ${bst.search(80)} (Expected: true)")
    
    // Inorder traversal before deletion
    println("\nInorder Traversal (before deletion): ${bst.inorderTraversal()}")
    println("Expected: [20, 30, 40, 50, 60, 70, 80]")
    
    // Delete a node
    println("\nDeleting 30...")
    bst.delete(30)
    println("Inorder Traversal (after deletion): ${bst.inorderTraversal()}")
    println("Expected: [20, 40, 50, 60, 70, 80]")
    
    // Delete another node
    println("\nDeleting 50 (root)...")
    bst.delete(50)
    println("Inorder Traversal (after deletion): ${bst.inorderTraversal()}")
    println("Expected: [20, 40, 60, 70, 80]")
}
